package helpers;

public final class LocalisationHelper {

    public static String getMainPageTitle(String locale) {
        String title;
        switch (locale) {
            case "MS" -> title = "Pengewangan kandungan anda dengan FapHouse";
            default -> title = "Monetize your content with FapHouse";
        }
        return title;
    }
}
