/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: [YOUR NAME HERE]
 *</p>
 */

public class DNA {
    // Our P value, which is a big prime number
    final static long P = 77557187;
    // Base/radix is 4 since we only have 4 letters
    final static int R = 4;
    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public int STRCount(String sequence, String STR)
    {
        int maxCount = 0;
        int counter = 0;
        int m = STR.length();
        // Hash STR
        long STRHash = hash(STR, STR.length());
        long value = 0;
        String check = sequence.substring(0, STR.length());
        long sequenceHash = 0;
        sequenceHash = hash(check, check.length());
        int index = STR.length();
        long RM = 1;
        for(int i = 1; i <= m -1; i++){
            RM = (R * RM) % P;
        }
        while(index < sequence.length()){
            if(STRHash != sequenceHash){
                /*
                if(index == 782){
                    // Remove the first term
                    sequenceHash = (long)(((sequenceHash + P) - check.charAt(0) * Math.pow(R, m - 1) % P) % P);
                    // Add next char to string
                    check += sequence.charAt(index);
                    index++;
                    check = check.substring(1);
                    // Add next term to has value
                    sequenceHash = (sequenceHash * R) + check.charAt(m - 1) % P;
                }

                 */
                if(index == 558){
                    System.out.println("ok");
                }
                // Remove the first term
                sequenceHash = (long)(((sequenceHash + P) - check.charAt(0) * Math.pow(R, m - 1) % P) % P);
                // Add next char to string
                check += sequence.charAt(index);
                index++;
                check = check.substring(1);
                // Add next term to has value
                sequenceHash = (sequenceHash * R) + check.charAt(m - 1) % P;
                /*
                if(STR.equals(sequence.substring(index - STR.length(), index))){
                    System.out.println("Yes");
                    value = hash(sequence.substring(index - STR.length(), index), m);
                }

                 */
            }
            // once we find a match
            else{
                System.out.println("Match");
                value = hash("ACTGG", 5);
                // Continue looking for an STR sequence
                while(STRHash == sequenceHash){
                    counter++;
                    // Grab the next STR length substring in sequence
                    sequenceHash = hash(sequence.substring(index, index + m), m);
                    index += m;
                }
                // Compare to see if the sequence of STR right now is greater than the previous sequence
                if(maxCount < counter){
                    maxCount = counter;
                    counter = 0;
                }
            }
        }
        return maxCount;
    }
    // Horner's Method
    public long hash(String t, int m){
        long h = 0;
        for(int i = 0; i < m; i++){
            h = (R * h + t.charAt(i)) % P;
        }
        return h;
    }
}
