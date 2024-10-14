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

    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public int STRCount(String sequence, String STR)
    {
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
            if(totalSTR == checkValue){
                counter++;
                i += STR.length();
                // Out of bounds error
                check = copy.substring(i, i + STR.length());
                checkValue = getValue(check);
            }
            else{
                if(maxCount < counter){
                    maxCount = counter;
                    counter = 0;
                }
            }
        }
        /*
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
        return maxCount;
    }
    public int getValue(String test){
        int total = 0;
        int aValue = 1;
        int cValue = 2;
        int gValue = 3;
        int tValue = 4;
        int totalOfSTR = 0;
        for(int i = 0; i < test.length(); i++) {
            if (test.charAt(i) == 'A') {
                totalOfSTR += Math.pow(aValue, i + 1);
            }
            else if (test.charAt(i) == 'C') {
                totalOfSTR += Math.pow(cValue, i + 1);
            }
            else if (test.charAt(i) == 'G') {
                totalOfSTR += Math.pow(gValue, i + 1);
            }
            else {
                totalOfSTR += Math.pow(tValue, i + 1);
            }
        }
        return total;
    }
}
