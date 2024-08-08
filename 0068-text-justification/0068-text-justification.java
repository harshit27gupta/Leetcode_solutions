class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> sol = new ArrayList<>();

        int added = 0; // Tracks the index of the first word in the current line.
        StringBuilder sb = new StringBuilder(); // StringBuilder to construct the current line.

        // Loop over all words.
        for (int x = 0; x < words.length; x++) {
            int len = 0; // Length of the current line.
            int y = added; // Index to track the end of the current line.
            
            // Calculate the length of the current line.
            while (y <= x) {
                len += words[y].length();
                y++;
            }
            len += y - added - 1; // Account for spaces between words.

            // Check if the length is within maxWidth.
            if (len <= maxWidth) {
                sb.append(words[x]); // Add word to the line if within maxWidth.
            } else {
                // Construct a line with justified text if length exceeds maxWidth.
                StringBuilder sb1 = new StringBuilder();
                for (int b = added; b < x; b++) {
                    sb1.append(words[b]);
                    if (b != x - 1) {
                        sb1.append(" ");
                    }
                }

                // Split the line into words to calculate space distribution.
                String[] buffer = sb1.toString().trim().split("\\s+");
                int currentLength = sb1.length();
                sb1.setLength(0); // Reset StringBuilder for re-use.

                int gaps = buffer.length - 1; // Number of gaps between words.
                int[] spacesInGap = new int[gaps]; // Array to store spaces in each gap.
                int spacesAdded = 0; // Counter for added spaces.

                // Distribute spaces to justify the line.
                while (currentLength + spacesAdded < maxWidth) {
                    if (gaps != 0) {
                        for (int n = 0; n < spacesInGap.length && currentLength + spacesAdded < maxWidth; n++) {
                            spacesInGap[n]++;
                            spacesAdded++;
                        }
                    } else {
                        break;
                    }
                }

                // Reconstruct the line with added spaces.
                sb1.append(increaseSpaces(buffer, spacesInGap));
                while (sb1.length() < maxWidth) {
                    sb1.append(" ");
                }

                sol.add(sb1.toString()); // Add the justified line to the result.
                sb.setLength(0); // Reset StringBuilder.
                added = x; // Update the start of the next line.
                x--; // Decrement x to reconsider the current word in the next iteration.
            }

            // Special handling for the last line.
            if (x == words.length - 1) {
                StringBuilder sb1 = new StringBuilder();
                for (int b = added; b <= x; b++) {
                    sb1.append(words[b]);
                    if (sb1.length() < maxWidth) {
                        sb1.append(" ");
                    }
                }

                // Add spaces at the end to reach maxWidth.
                int currentLength = sb1.length();
                int rem = maxWidth - currentLength;
                for (int a = 0; a < rem; a++) {
                    sb1.append(" ");
                }

                sol.add(sb1.toString()); // Add the last line to the result.
            }
        }

        return sol; // Return the list of justified lines.
    }

    // Helper method to add spaces between words.
    public String increaseSpaces(String[] sentence, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length; i++) {
            sb.append(sentence[i]);
            if (i < sentence.length - 1 && i < spaces.length) {
                for (int j = 0; j <= spaces[i]; j++) {
                    sb.append(" ");
                }
            }
        }

        return sb.toString(); // Return the sentence with adjusted spaces.
    }
}