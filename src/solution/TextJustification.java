package solution;

import java.util.ArrayList;

/**
 * @author Sophie Song
 * @since 2017/5/3
 * https://leetcode.com/problems/text-justification/#/description
 */
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<>();

        if(words == null || words.length == 0){
            return result;
        }

        int count = 0;//上一次计算的单词的长度
        int last = 0;//截止到当前行次用了多少个单词

        for(int i=0; i<words.length; i++) {

            //count是截止到当前次，计算出来的单词长度
            //words[i].length()是当前词的长度
            //i-last是当前空格的长度 （因为一共用了i个次，而截止到当前行用了last个，所以当前行用了i-last个词）

            //这三样相加，就是当前行的字符的长度

            if(count + words[i].length() + (i-last) > L) {
                int spaceNum = 0;
                int extraNum = 0;

                if(i - last - 1 > 0) { //减一是因为最后没有用words[i]
                    spaceNum = (L-count) / (i-last-1); //如果空格数正好可以是倍数
                    extraNum = (L-count) % (i-last-1); //如果不能是倍数，还得算多余出来几个
                }

                StringBuilder sb = new StringBuilder();

                for(int j = last; j<i; j++) {
                    sb.append(words[j]);
                    if(j<i-1){
                        for(int k=0; k<spaceNum; k++) {
                            sb.append(" ");
                        }
                        if(extraNum > 0) {
                            sb.append(" ");
                            extraNum--;
                        }
                    }
                }

                for(int j=sb.length(); j<L; j++) {
                    sb.append(" ");
                }

                result.add(sb.toString());
                count = 0;
                last = i;
            }

            count = count + words[i].length();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=last; i<words.length; i++) {
            sb.append(words[i]);
            if(sb.length() < L) {
                sb.append(" ");
            }
        }

        for(int i=sb.length(); i<L; i++) {
            sb.append(" ");
        }
        result.add(sb.toString());
        return result;
    }
}
