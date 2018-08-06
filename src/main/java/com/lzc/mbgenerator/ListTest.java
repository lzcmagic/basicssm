package com.lzc.mbgenerator;

import com.lzc.basicssm.bean.DiaryBean;
import com.lzc.basicssm.entity.Diary;
import com.lzc.basicssm.utils.DateFormatUtil;

import java.util.*;

public class ListTest {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(0);
        list.add(0);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(3);

        new ListTest().assembleDiaries(list);

    }

    private void assembleDiaries(List<Integer> diaries) {


        List<Integer> cloenList = new ArrayList<>(diaries);

        Map<Integer, List<Object>> map = new HashMap<>();
        for (int i = 0; i < diaries.size(); i++) {
            int temp1 = diaries.get(i);
            List<Object> objects = new ArrayList<>();
            for (Integer aCloenList : cloenList) {
                int temp2 = aCloenList;
                if (temp1 == temp2) {
                    objects.add(temp2);
                }
            }
            map.put(i, objects);
        }

        Iterator<Map.Entry<Integer, List<Object>>> iterator = map.entrySet().iterator();
        Set<Object> sets=new HashSet<>();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Object>> next = iterator.next();
            sets.add(next.getValue());
            System.out.println("i: " + next.getKey() + " pbj: " + next.getValue());
        }
        System.out.println("set: " + sets);


    }
}
