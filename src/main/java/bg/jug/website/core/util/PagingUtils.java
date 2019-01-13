package bg.jug.website.core.util;

public class PagingUtils {

    public static int findPageStartingElement(int page, int size) {
        return (page - 1) * size;
    }

}
