import java.util.*;
public class LongestSubstringWithAtMostKDistinctChar159{


    public static void main(String[] args){
     String s = "eceba";
     int k =2;
     //int result  = LongestSubstring(s,k);

     //System.out.println("result is  "+result);

     int result1  = MinSubstring(s,k);
     System.out.println("result1 is  "+result1);


    }

    public static int LongestSubstring(String s , int K){

     int leftP=0;
     int rightP=0;
     Map<Character,Integer> characterCountMap = new HashMap<>();
     int max = Integer.MIN_VALUE;
     // int count =0;   

     while(rightP<s.length()){

        Character cRightP = s.charAt(rightP);
        characterCountMap.put(cRightP,characterCountMap.getOrDefault(cRightP,0)+1);
    
        rightP++;
       //Increase the window until invalid [for longest].
       //start inner while loop after the condition is violated
        while(characterCountMap.size()>K){
            Character cLeftP = s.charAt(leftP);
            characterCountMap.put(cLeftP,characterCountMap.getOrDefault(cLeftP, 0)-1);
            if(characterCountMap.get(cLeftP)<=0){
                characterCountMap.remove(cLeftP);

            }
            leftP++;

        }
        max = Math.max(max,rightP-leftP);

         // count of all windows/subarray meeting the condition.[count of subarrays WithAtMostKDistinctChar]
        // count = count + rightP-leftP
       
       

     }


        return max;
    }


    public static int MinSubstring(String s , int K){

        int leftP=0;
        int rightP=0;
        Map<Character,Integer> characterCountMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
   
        while(rightP<s.length()){
   
           Character cRightP = s.charAt(rightP);
           characterCountMap.put(cRightP,characterCountMap.getOrDefault(cRightP,0)+1);
       
           rightP++;
           //Increase the window strictly till valid [ for shortest] but never beyond valid. start inner while loop the moment
           //when valid window is found.
           while(characterCountMap.size()<=2 &&  characterCountMap.size()!=0 ){
            System.out.println("leftP "  +leftP+"rightP "+ rightP);
               // min is found within inner loop always
               min = Math.min(min, rightP-leftP);
               System.out.println("min " +min);
               Character cLeftP = s.charAt(leftP);
               characterCountMap.put(cLeftP,characterCountMap.getOrDefault(cLeftP, 0)-1);
               if(characterCountMap.get(cLeftP)<=0){
                   characterCountMap.remove(cLeftP);
   
               }
               leftP++;
   
           }
          // max = Math.max(max,rightP-leftP);
          
   
        }
   
   
           return min;
       }
}
