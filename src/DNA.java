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
    final static long P = 28871271685163L;
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
        System.out.println(STR);
        while(index < sequence.length()){
            // Remove leading digit
            sequenceHash = (sequenceHash + P - RM * sequence.charAt(index - m) % P) % P;
            check = check.substring(1);
            // add trailing digit
            sequenceHash = (sequenceHash * R + sequence.charAt(index)) % P;
            check += sequence.charAt(index);
            if(STRHash == sequenceHash){
                maxCount++;
            }
            index++;
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
