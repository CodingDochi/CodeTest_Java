package credit_card_mask;

public class Maskify {
    public static String maskify(String str) {

        if (str.length() < 4) {
            return str;
        } else {
            String to_keep = str.substring(str.length() - 4);
            int mask_length = str.length() - 4;
            String mask = "#";
            if (mask_length > 0) {
                for (int i = 1; i < mask_length; i++) {
                    mask = mask.concat("#");
                }
                mask = mask.concat(to_keep);
            } else {
                mask = to_keep;
            }

            return mask;
        }
    }

}
