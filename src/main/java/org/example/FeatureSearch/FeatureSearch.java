package org.example.FeatureSearch;

import org.example.PatentAnalysis.PatentFeatureExtractor;

import java.util.HashMap;
import java.util.Set;

public class FeatureSearch {

    public static Double calculatePercentage(Set<String> set1, Set<String> set2) {
        int count = 0;
        for (String str : set2) {
            if (set1.contains(str)) {
                count++;
            }
        }
        return ((double) count / set2.size()) * 100;
    }

    public static HashMap<Integer, Double> featureMatchPercentage(Set<Integer> relevantPatentIDs, Integer OriginalPatentId){
        Set<String> originalPatentFeatures = getPatentFeatures(OriginalPatentId);
        HashMap<Integer, Double> PatentPercentageMatch = new HashMap<>();
        for(Integer patentID : relevantPatentIDs){
            Set<String> patentFeatures = getPatentFeatures(patentID);
            Double commonFeaturePercentage =  calculatePercentage(patentFeatures, originalPatentFeatures);
            PatentPercentageMatch.put(patentID,commonFeaturePercentage);
        }
        return PatentPercentageMatch;
    }

    public static Set<String> getPatentFeatures(Integer patentID){
        return PatentFeatureExtractor.getPatentFeatures(patentID);
    }
}
