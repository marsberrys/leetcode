package solutions.s1436;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author weixun
 * @Date 2021-10-01
 * @See https://leetcode-cn.com/problems/destination-city/
 */
public class Solution {

    public String destCity(List<List<String>> paths) {
        Set<String> fromCities = new HashSet<>();
        for (List<String> path : paths) {
            fromCities.add(path.get(0));
        }

        for (List<String> path : paths) {
            if(!fromCities.contains(path.get(1))) {
                return path.get(1);
            }
        }

        return null;
    }

    @Test
    public void test() {

        Assert.assertEquals("Sao Paulo" , destCity(Arrays.asList(
                Arrays.asList("London","New York"),
                Arrays.asList("New York","Lima"),
                Arrays.asList("Lima","Sao Paulo")
        )));

        Assert.assertEquals("A" , destCity(Arrays.asList(
                Arrays.asList("B","C"),
                Arrays.asList("D","B"),
                Arrays.asList("C","A")
        )));

        Assert.assertEquals("Z" , destCity(Arrays.asList(
                Arrays.asList("A","Z")
        )));

        Assert.assertEquals("wxAscRuzOl" , destCity(Arrays.asList(
                Arrays.asList("pYyNGfBYbm","wxAscRuzOl"),
                Arrays.asList("kzwEQHfwce","pYyNGfBYbm")
        )));

        System.out.println("ok");
    }
}
