package bg.jug.website.core.util;

import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import net.minidev.json.JSONObject;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.List;

@ApplicationScoped
public class JwtUtils {
    private PrivateKey privateKey;

    @PostConstruct
    public void initializePrivateKey() {
        try {
            privateKey = readPrivateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String generateJWT(String email, List<String> roles, int expiresInSeconds) {
        JSONObject claims = new JSONObject();

        claims.put("iss", "https://jug.bg");
        claims.put("upn", email);
        claims.put("sub", email);

        long currentTimeInSeconds = System.currentTimeMillis() / 1000;
        claims.put("iat", currentTimeInSeconds);
        claims.put("exp", currentTimeInSeconds + expiresInSeconds);
        claims.put("auth_time", currentTimeInSeconds);
        claims.put("roles", roles);

        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256)
                .keyID("BGJUG")
                .type(JOSEObjectType.JWT)
                .build();

        try {
            JWTClaimsSet claimsSet = JWTClaimsSet.parse(claims);
            SignedJWT jwt = new SignedJWT(header, claimsSet);
            jwt.sign(new RSASSASigner(privateKey));
            return jwt.serialize();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static PrivateKey readPrivateKey() {
        InputStream contentIS = JwtUtils.class.getResourceAsStream("/key.pem");
        byte[] tmp = new byte[4096];
        try {
            int length = contentIS.read(tmp);
            return decodePrivateKey(new String(tmp, 0, length));
        } catch (Exception ex) {
            throw new RuntimeException("Could not read private key", ex);
        }
    }

    private static PrivateKey decodePrivateKey(String pemEncoded) throws Exception {
        pemEncoded = removeBeginEnd(pemEncoded);
        byte[] pkcs8EncodedBytes = Base64.getDecoder().decode(pemEncoded);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pkcs8EncodedBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(keySpec);
    }

    private static String removeBeginEnd(String pem) {
        pem = pem.replaceAll("-----BEGIN (.*)-----", "");
        pem = pem.replaceAll("-----END (.*)----", "");
        pem = pem.replaceAll("\r\n", "");
        pem = pem.replaceAll("\n", "");
        return pem.trim();
    }


}
