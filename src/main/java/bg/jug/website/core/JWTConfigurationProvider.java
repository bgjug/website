package bg.jug.website.core;

import org.apache.tomee.microprofile.jwt.config.JWTAuthContextInfo;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Optional;

@Dependent
public class JWTConfigurationProvider {

    @Produces
    Optional<JWTAuthContextInfo> getOptionalContextInfo() throws NoSuchAlgorithmException, InvalidKeySpecException {
        final String pemEncoded = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6+L8vbGVQbArsujxH8S7" +
                "9z+5OhTWY3/LgVNBBLbJq4ykqTvfvo+A2T9fCsVI30VLbijQc1663rGh4kRcivFS" +
                "ksJZCjyfAOcmd2eDTVs6Sx3RB10IaDGRku4c1/ganBoEHM7X7OAcy3bMOeSYUBcH" +
                "lTAVcHkMbwXRsEAMN03CO5LhMtvX2Z+3Uv1l4jxTw81tgcdEUAhoAAb1A3jKD7NV" +
                "fxrizEucegPl709EK42gfR6GnHNNws04CbDEIXOT8wHa4/+X1HH471L6LpI0hTNk" +
                "AcKqnUNEZiqxkMj2IPZ8JVvYi7daNuLu5Q26fBe1esiif6foJP2wSsmXBTZIYzL1" +
                "xQIDAQAB";
        byte[] encodedBytes = Base64.getDecoder().decode(pemEncoded);

        final X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedBytes);
        final KeyFactory kf = KeyFactory.getInstance("RSA");
        final RSAPublicKey pk = (RSAPublicKey) kf.generatePublic(spec);

        return Optional.of(new JWTAuthContextInfo(pk, "https://jug.bg"));
    }

    @Produces
    JWTAuthContextInfo getContextInfo() throws InvalidKeySpecException, NoSuchAlgorithmException {
        return getOptionalContextInfo().get();
    }
}
