package top150.array;
// https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150
public class RomanToInteger {

    public  enum RomanChar
    {

        I(1){
            protected boolean canCombineWith(RomanChar ch){
                return ch == V || ch == X ;
            }

        },
        V(5),
        X(10){
            protected boolean canCombineWith(RomanChar ch){
                return ch == L || ch == C ;
            }

        },
        L(50),
        C(100){
            protected boolean canCombineWith(RomanChar ch){
                return ch == D || ch == M ;
            }


        },
        D(500),
        M(1000);


        RomanChar(int value) {
            this.value = value ;
        }

        protected  int value ;

        public int  combine(RomanChar ch){
            if(this.canCombineWith(ch)){
                return ch.getValue() - this.getValue();
            }
            return value ;
        }

        protected boolean canCombineWith(RomanChar ch){
            return false ;
        }
        public int getValue(){
            return value ;
        }
    } ;

    public int romanToInt(String s) {

        int total = 0 ;
        for(int index = 0 ; index < s.length() ; index++){
            RomanChar  currentChar = RomanChar.valueOf(String.valueOf(s.charAt(index)));
            if(index+1 < s.length()){
                RomanChar  nextChar = RomanChar.valueOf(String.valueOf(s.charAt(index+1)));
                if(currentChar.combine(nextChar) != currentChar.getValue()){
                    total += currentChar.combine(nextChar);
                    index++;
                }
                else{
                    total += currentChar.getValue();
                }
            }else{
                total += currentChar.getValue();
            }
        }

        return total ;
    }

    public static void main(String args[]){
        RomanToInteger romanToInteger = new RomanToInteger();

        System.out.println(romanToInteger.romanToInt("III"));
    }
}
