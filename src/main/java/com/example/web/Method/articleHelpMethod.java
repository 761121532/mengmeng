package com.example.web.Method;

import com.example.web.DAO.ArticleMapper;
import com.example.web.Entity.ArticleEntity;
import com.example.web.RedisUtil.redisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 文章操作的帮助方法
 */
public class articleHelpMethod {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    redisUtil redisUtil;
    //将传过来的map的value取出来转为int数组
    public int[] getArticleId(int[] proportion,int[] id,int number) {
        int[] b = new int[proportion.length];                           //临时变量随意取名
        int[] c;
        if (proportion.length < 7) {
            c = new int[proportion.length];//临时变量随意取名
        } else {
            c = new int[proportion.length-(7*number)];//临时变量随意取名
        }
        System.arraycopy(proportion, 0, b, 0, b.length);
        proportion = IntStream.of(proportion)  // 变为 IntStream
                .boxed()           // 变为 Stream<Integer>
                .sorted(Comparator.reverseOrder()) // 按自然序的相反序排序
                .mapToInt(Integer::intValue)       // 变为 IntStream
                .toArray();  // 变为 int[]
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[j] == proportion[i]) {
                    b[j] = -1;
                    c[i] = id[j+(number*7)];
                    break;
                }
            }
            if (proportion.length == i + 1) break;
        }
        return c;
    }

    public String change(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = String.valueOf(c).getBytes("utf-8");
                } catch (Exception ex) {
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }
    public int[] aaa(int number){
        //遍历出所有的文章的比重，存入一个map里面去，key为id，value为比重值
        ArticleEntity[] articleEntitys = articleMapper.findProportion();
        Map<String, Object> propOrtion = new HashMap<>();
        int[] id = new int[articleEntitys.length];                //装有所有文章id的数组
        int[] proportions = new int[articleEntitys.length];       //装着文章比重的数组
        for (int i = 0; i < articleEntitys.length; i++) {
            id[i] = articleEntitys[i].getId();
            proportions[i] = articleEntitys[i].getProportion();
            propOrtion.put(articleEntitys[i].getId() + "", articleEntitys[i].getProportion() + "");
        }
        redisUtil.hmset("maps", propOrtion);                                 //将所有map取出放到redis里面去，方便下次调用
        int[] articleId = getArticleId(proportions,id,number);            //取出比重最高的文章id
        return articleId;
    }
}
