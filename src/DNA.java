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
    // 28871271685163L
    final static long P = 2887127168L;
    // Base/radix is 4 since we only have 4 letters
    final static int R = 85;
    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public int STRCount(String sequence, String STR)
    {
        int maxCount = 0;
        int counter = 0;
        int m = STR.length();
        // STR hash value
        long STRHash = hash(STR, STR.length(),0);
        long value = 0;
        // The hash value of the group of letters we are currently looking at
        long sequenceHash = hash(sequence, STR.length(),0);
        int index = STR.length();
        long RM = 1;
        for(int i = 1; i <= m -1; i++){
            RM = (R * RM) % P;
        }
        // Case for if the first letters are STR (doesn't happen in test cases though)
        if(STRHash == sequenceHash){
            // Continue looking for STR in length m strings
            while(STRHash == sequenceHash){
                index++;
                sequenceHash = hash(sequence, m, index);
                counter++;
                // So that we move onto the next group of letters
                index += m -1;
            }
            if(maxCount < counter){
                maxCount = counter;
            }
            counter = 0;
            index++;
        }
        // Iterate through sequence
        while(index < sequence.length()){
            // Remove leading digit
            sequenceHash = (sequenceHash + P - (RM * sequence.charAt(index - m) % P)) % P;
            // add trailing digit
            sequenceHash = (sequenceHash * R + sequence.charAt(index)) % P;
            if(STRHash == sequenceHash){
                // Continue looking for STR in length m strings
                while(STRHash == sequenceHash){
                    index++;
                    sequenceHash = hash(sequence, m, index);
                    counter++;
                    // So that we move onto the next group of letters
                    index += m - 1;
                }
                if(maxCount < counter){
                    maxCount = counter;
                }
                counter = 0;
            }
            index++;
        }
        return maxCount;
    }
    // Horner's Method
    public long hash(String t, int m, int start){
        long h = 0;
        for(int i = start; i < start + m; i++){
            h = (R * h + t.charAt(i)) % P;
        }
        return h;
    }
}
