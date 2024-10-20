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
    final static long P = 104561;
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
        String check = sequence.substring(0, STR.length());
        long sequenceHash = 0;
        sequenceHash = hash(check, check.length());
        int index = STR.length();
        while(index < sequence.length()){
            if(STRHash != sequenceHash){
                // Remove the first term
                sequenceHash = (long)(((sequenceHash + P) - check.charAt(0) * Math.pow(R, m - 1) % P) % P);
                check += sequence.charAt(index);
                index++;
                check = check.substring(1);
                // Add next term
                sequenceHash = (sequenceHash * R) + check.charAt(m - 1) % P;
                if(maxCount < counter){
                    maxCount = counter;
                    counter = 0;
                }
            }
            else{
                counter++;
                index++;
            }
        }
        return maxCount;
        /*
        String copy = sequence;
        int maxCount = 0;
        int counter = 0;
        // Calculate the value of STR
        int aValue = 1;
        int cValue = 2;
        int gValue = 3;
        int tValue = 4;
        int i = copy.indexOf(STR);
        int totalSTR = getValue(STR);
        String check = copy.substring(i, i + STR.length());
        int checkValue = getValue(check);
        while(copy.contains(STR)){
            if(!(totalSTR == checkValue)){
                if(maxCount < counter){
                    maxCount = counter;
                    counter = 0;
                }
            }
            else{
                counter++;
            }
            i += STR.length();
            // Out of bounds error
            check = copy.substring(i, i + STR.length());
            checkValue = getValue(check);
        }
        // Copy of sequence so we can actively chop it
        String copy = sequence;
        int i = 0;
        int maxCount = 0;
        int counter = 0;
        String check = "";
        i = sequence.indexOf(STR);
        // Continue iterating until there is no more STR in copy
        while(copy.contains(STR)){
            // Get the next STR length word
            check = copy.substring(i, i + STR.length());
            // Continue iterating until we find there is no more STR to count
            while(STR.equals(check)){
                counter++;
                i += STR.length();
                check = copy.substring(i, i + STR.length());
            }
            // Compare the max amount fo STRs we found vs how many STR we just counted
            if(maxCount < counter){
                maxCount = counter;
            }
            counter = 0;
            // Chop copy
            copy = copy.substring(i);
            i = copy.indexOf(STR);
        }
        return maxCount;

         */
    }
    public long hash(String t, int m){
        long h = 0;
        for(int i = 0; i < m; i++){
            h = (R * h + t.charAt(i)) % P;
        }
        return h;
    }
}
