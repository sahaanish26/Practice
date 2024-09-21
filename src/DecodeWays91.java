import java.util.*;

public class DecodeWays91 {

    public static int numberOfcalls1;
    public static int numberOfcalls2;
    public static int numberOfcallsDP;
    
    

    public static void main(String[] args){
    
         List<List<String>> result = new ArrayList<>();
         List<List<String>> result1 = new ArrayList<>();
         List<List<String>> result2 = new ArrayList<>();
        String s = "121269";
      //  String s = "226";
      // String s = "226";
        List<Character> choices = new ArrayList<>();
        for (int i=0 ; i<s.length();i++){
            choices.add(s.charAt(i));
        }
        combineHelperOneOrTwoAtaTime(new ArrayList(), choices, result);
        System.out.println(result);
        System.out.println("number of calls for void "+ numberOfcalls1);
        System.out.println(combineHelperOneOrTwoAtaTimeInt(new ArrayList(), choices, result1));
        System.out.println("number of calls for int "+ numberOfcalls2);
        
        Map<List<Character>,Integer> cacheMap= new HashMap<>();
        System.out.println(combineHelperOneOrTwoAtaTimeIntDP(new ArrayList(), choices, result2,cacheMap));
        System.out.println("number of calls for DP "+ numberOfcallsDP);
        


        
    }

    private static void combineHelperOneOrTwoAtaTime(ArrayList chosen, List<Character> choices,
            List<List<String>> res) {
                numberOfcalls1++;
                if(choices.size() == 0) {
                    res.add(new ArrayList<>(chosen));
                } else if ( choices.size() >1) {
                    //check f
                    // chose explore unchoose without selecting first choice
                   Character firstChoice = choices.get(0);
                   Character secondChoice = choices.get(1);
                   //consider the choice is not there
                   //choices.remove(0);
                  // combineHelperOneOrTwoAtaTime(chosen,choices,res,k);
                   //choices.add(0,firstChoice);
        
                    // chose explore unchoose with selecting first choice
                    if(Integer.parseInt(firstChoice.toString())>0){
                   chosen.add(firstChoice.toString());
                   choices.remove(0);
                   combineHelperOneOrTwoAtaTime(chosen,choices,res);
                   chosen.remove(chosen.size()-1);
                   choices.add(0,firstChoice);
                    }
                    String twoCharactersTogether = firstChoice.toString()+secondChoice.toString();
        
                    if(Integer.parseInt(twoCharactersTogether)<=26 && Integer.parseInt(twoCharactersTogether)>=10 ){
                   chosen.add(firstChoice.toString()+secondChoice.toString());
                   
                   choices.remove(0);
                   choices.remove(0);
                   combineHelperOneOrTwoAtaTime(chosen,choices,res);
                   chosen.remove(chosen.size()-1);
                   //chosen.remove(chosen.size()-1);
                   choices.add(0,firstChoice);
                   choices.add(1,secondChoice);
                    }
        
                }
                else if ( choices.size()==1) {
                    // chose explore unchoose without selecting first choice
                   Character firstChoice = choices.get(0);
                   
                   //consider the choice is not there
                   //choices.remove(0);
                  // combineHelperOneOrTwoAtaTime(chosen,choices,res,k);
                   //choices.add(0,firstChoice);
        
                    // chose explore unchoose with selecting first choice
                    if(Integer.parseInt(firstChoice.toString())>0){
                   chosen.add(firstChoice.toString());
                   choices.remove(0);
                   combineHelperOneOrTwoAtaTime(chosen,choices,res);
                   chosen.remove(chosen.size()-1);
                   choices.add(0,firstChoice);
                    }
                }
            }
 

    private static int combineHelperOneOrTwoAtaTimeInt(ArrayList chosen, List<Character> choices,
            List<List<String>> res) {
                numberOfcalls2++;
              //  System.out.println("choices"+choices+"chosen"+chosen);
              //  System.out.println("                             ");

                if(choices.size() == 0) {
                    res.add(new ArrayList<>(chosen));
                    return 1;
                } else if ( choices.size() >1) {
                    //check f
                    // chose explore unchoose without selecting first choice
                   Character firstChoice = choices.get(0);
                   Character secondChoice = choices.get(1);
                   //consider the choice is not there
                   //choices.remove(0);
                  // combineHelperOneOrTwoAtaTime(chosen,choices,res,k);
                   //choices.add(0,firstChoice);
        
                    // chose explore unchoose with selecting first choice
                    int numberOfWay1 =0;
                    int numberofWay2=0;
                    if(Integer.parseInt(firstChoice.toString())>0){
                   chosen.add(firstChoice.toString());
                   choices.remove(0);
                   numberOfWay1 =combineHelperOneOrTwoAtaTimeInt(chosen,choices,res);
                   chosen.remove(chosen.size()-1);
                   choices.add(0,firstChoice);
                    }
                    String twoCharactersTogether = firstChoice.toString()+secondChoice.toString();
        
                    if(Integer.parseInt(twoCharactersTogether)<=26 && Integer.parseInt(twoCharactersTogether)>=10 ){
                   chosen.add(firstChoice.toString()+secondChoice.toString());
                   
                   choices.remove(0);
                   choices.remove(0);
                   numberofWay2 =combineHelperOneOrTwoAtaTimeInt(chosen,choices,res);
                   chosen.remove(chosen.size()-1);
                   //chosen.remove(chosen.size()-1);
                   choices.add(0,firstChoice);
                   choices.add(1,secondChoice);

                  
                    }
                    return numberOfWay1+numberofWay2;
        
                }
                else if ( choices.size()==1) {
                    // chose explore unchoose without selecting first choice
                   Character firstChoice = choices.get(0);
                   
                   //consider the choice is not there
                   //choices.remove(0);
                  // combineHelperOneOrTwoAtaTime(chosen,choices,res,k);
                   //choices.add(0,firstChoice);
                   
                    // chose explore unchoose with selecting first choice
                    int numberOfWay1 =0;
                    if(Integer.parseInt(firstChoice.toString())>0){
                   chosen.add(firstChoice.toString());
                   choices.remove(0);
                   numberOfWay1 = combineHelperOneOrTwoAtaTimeInt(chosen,choices,res);
                   chosen.remove(chosen.size()-1);
                   choices.add(0,firstChoice);
                    }
                    return numberOfWay1;
                }

                return 0;
            }

    private static int combineHelperOneOrTwoAtaTimeIntDP(ArrayList chosen, List<Character> choices,
            List<List<String>> res, Map<List<Character>, Integer> cacheMap) {
                numberOfcallsDP++;
              //  System.out.println("choices"+choices+"chosen"+chosen);
              //  System.out.println("                             ");
                if(cacheMap.containsKey(choices)){
                    System.out.println("Condition Met for" +choices + "   " + cacheMap.get(choices));
                    return cacheMap.get(choices);
                }

                if(choices.size() == 0) {
                    res.add(new ArrayList<>(chosen));
                    return 1;
                } else if ( choices.size() >1) {
                    //check f
                    // chose explore unchoose without selecting first choice
                   Character firstChoice = choices.get(0);
                   Character secondChoice = choices.get(1);
                   //consider the choice is not there
                   //choices.remove(0);
                  // combineHelperOneOrTwoAtaTime(chosen,choices,res,k);
                   //choices.add(0,firstChoice);
        
                    // chose explore unchoose with selecting first choice
                    int numberOfWay1 =0;
                    int numberofWay2=0;
                    if(Integer.parseInt(firstChoice.toString())>0){
                   chosen.add(firstChoice.toString());
                   choices.remove(0);
                   numberOfWay1 =combineHelperOneOrTwoAtaTimeIntDP(chosen,choices,res,cacheMap);
                   chosen.remove(chosen.size()-1);
                   choices.add(0,firstChoice);
                    }
                    String twoCharactersTogether = firstChoice.toString()+secondChoice.toString();
        
                    if(Integer.parseInt(twoCharactersTogether)<=26 && Integer.parseInt(twoCharactersTogether)>=10 ){
                   chosen.add(firstChoice.toString()+secondChoice.toString());
                   
                   choices.remove(0);
                   choices.remove(0);
                   numberofWay2 =combineHelperOneOrTwoAtaTimeIntDP(chosen,choices,res,cacheMap);
                   chosen.remove(chosen.size()-1);
                   //chosen.remove(chosen.size()-1);
                   choices.add(0,firstChoice);
                   choices.add(1,secondChoice);

                  
                    }
                    cacheMap.put(choices,numberOfWay1+numberofWay2);
                    return numberOfWay1+numberofWay2;
        
                }
                else if ( choices.size()==1) {
                    // chose explore unchoose without selecting first choice
                   Character firstChoice = choices.get(0);
                   
                   //consider the choice is not there
                   //choices.remove(0);
                  // combineHelperOneOrTwoAtaTime(chosen,choices,res,k);
                   //choices.add(0,firstChoice);
                   
                    // chose explore unchoose with selecting first choice
                    int numberOfWay1 =0;
                    if(Integer.parseInt(firstChoice.toString())>0){
                   chosen.add(firstChoice.toString());
                   choices.remove(0);
                   numberOfWay1 = combineHelperOneOrTwoAtaTimeIntDP(chosen,choices,res,cacheMap);
                   chosen.remove(chosen.size()-1);
                   choices.add(0,firstChoice);
                    }
                    cacheMap.put(choices,numberOfWay1);
                    return numberOfWay1;
                }
                cacheMap.put(choices,0);
                return 0;
            }


         }
    

