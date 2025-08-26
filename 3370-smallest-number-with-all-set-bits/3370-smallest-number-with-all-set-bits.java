class Solution 
{
    public int smallestNumber(int n) 
    {
        int x = n;
        
        // Step 1: Check if x has all bits set
        while ((x & (x + 1)) != 0) 
        { 
            x++; // Step 2: Increment x until the condition is met
        }
        
        return x; // Step 3 : Return Smallest Number with All Set Bits 
    }
}