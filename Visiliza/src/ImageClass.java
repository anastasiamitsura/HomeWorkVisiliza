public class ImageClass {
    public String getImg(int lifeCount) { // Получяение изображения виселицы
        if (lifeCount == 5) {
            return
                    "\n" +
                            " \n" +
                            "  \n" +
                            "  \n" +
                            "  \n" +
                            "  \n" +
                            "=========";
        } else if (lifeCount == 4) {
            return
                    "+--------+\n" +
                            "  |        \n" +
                            "  |        \n" +
                            "  |        \n" +
                            "  |         \n" +
                            "  |   \n" +
                            "=========";
        } else if (lifeCount == 3) {
            return
                    "+--------+\n" +
                            "  |      |\n" +
                            "  |      O\n" +
                            "  |      |\n" +
                            "  |        \n" +
                            "  |   \n" +
                            "=========";
        } else if (lifeCount == 2) {
            return
                    "+--------+\n" +
                            "  |      |\n" +
                            "  |      O\n" +
                            "  |     /|| \n" +
                            "  |       \n" +
                            "  |   \n" +
                            "=========";

        } else {
            return "+--------+\n" +
                    "  |      |\n" +
                    "  |      O\n" +
                    "  |     /|| \n" +
                    "  |      /| \n" +
                    "  |   \n" +
                    "=========";
        }
    }
}
