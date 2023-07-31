package top150.slidingwindow;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/?envType=study-plan-v2&envId=top-interview-150
public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        int wordLength = words[0].length();
        Map<String , Integer> wordCountMap = new HashMap<>();
        Set<Integer> ans = new HashSet<>();
        for(String word : words){
            wordCountMap.put(word , wordCountMap.getOrDefault(word , 0)+1);
        }

        for(int index = 0 ; index < wordLength ; index++) {
            int beginIndex = index;
            int endIndex = index;
            int count = words.length;
            Map<String, Integer> clonedMap = new HashMap<>(wordCountMap);

            while (endIndex + wordLength<= s.length()) {

                String word = s.substring(endIndex, endIndex + wordLength);

                if (clonedMap.containsKey(word)) {


                    int wordCount = clonedMap.get(word) - 1;
                    if (wordCount >= 0) {
                        count--;
                        clonedMap.put(word, wordCount);
                        if (count == 0) {
                            ans.add(beginIndex);

                            String beginWord = s.substring(beginIndex, beginIndex + wordLength);
                            clonedMap.put(beginWord, clonedMap.get(beginWord) + 1);
                            count++;

                            beginIndex += wordLength;


                        }
                        endIndex += wordLength;

                    } else {
                        while (!s.substring(beginIndex, beginIndex + wordLength).equals(word)) {
                            String beginWord = s.substring(beginIndex, beginIndex + wordLength);
                            clonedMap.put(beginWord, clonedMap.get(beginWord) + 1);
                            count++;
                            beginIndex += wordLength;
                        }
                        String beginWord = s.substring(beginIndex, beginIndex + wordLength);
                        clonedMap.put(beginWord, clonedMap.get(beginWord) + 1);
                        beginIndex += wordLength;
                        count++;


                    }
                } else {
                    count = words.length;
                    endIndex += wordLength;
                    beginIndex = endIndex;
                    clonedMap = new HashMap<>(wordCountMap);
                }
            }
        }
        return new ArrayList<>(ans) ;
    }

    public static void main(String args[]){
        SubstringwithConcatenationofAllWords substringwithConcatenationofAllWords = new SubstringwithConcatenationofAllWords();

        System.out.println(
                substringwithConcatenationofAllWords.findSubstring("barfoothefoobarman"
                        , new String[] {"foo","bar"})
        );

        System.out.println(
                substringwithConcatenationofAllWords.findSubstring("wordgoodgoodgoodbestword"
                        , new String[] {"word","good","best","word"})
        );

        System.out.println(
                substringwithConcatenationofAllWords.findSubstring("barfoofoobarthefoobarman"
                        , new String[] {"bar","foo","the"})
        );

        System.out.println(
                substringwithConcatenationofAllWords.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake"
                        , new String[] {"fooo","barr","wing","ding","wing"})
        );

        System.out.println(
                substringwithConcatenationofAllWords.findSubstring("wordgoodgoodgoodbestword"
                        , new String[] {"word","good","best","good"})
        );


//        System.out.println(
//                substringwithConcatenationofAllWords.findSubstring("pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel"
//                        , new String[] {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"})
//        );
    }
}
