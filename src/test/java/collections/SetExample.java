package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public final Set<String> bands = new HashSet<>();
    public void addBands(String value) {
        bands.add(value);
    }
    public void removeBands(String value) {
        bands.remove(value);
    }
    public void getBands(Set<String> bands) {
        for (String band : bands) {
            System.out.println("List: " + band);
        }
    }

    public final Set<String> bandsLinkedHashSet = new LinkedHashSet<>();
    public void addLinkedHashSetBands(String value) {
        bandsLinkedHashSet.add(value);
    }
    public void removeLinkedHashSetBands(String value) {
        bandsLinkedHashSet.remove(value);
    }

    public final Set<String> bandsTreeSet = new TreeSet<>();
    public void addTreeSet(String value) {
        bandsTreeSet.add(value);
    }
    public void removeTreeSet(String value) {
        bandsTreeSet.remove(value);
    }

    public static void main(String[] args) {

        SetExample setExample = new SetExample();
        setExample.addBands("Dissection");
        setExample.addBands("Summoning");
        setExample.addBands("Mayhem");
        setExample.addBands("Yellow Eye");
        setExample.addBands("Yellow Eye");
        setExample.addBands("Swans");
        setExample.removeBands("Swans");
        setExample.getBands(setExample.bands);

        setExample.addLinkedHashSetBands("Dissection");
        setExample.addLinkedHashSetBands("Summoning");
        setExample.addLinkedHashSetBands("Mayhem");
        setExample.addLinkedHashSetBands("Yellow Eye");
        setExample.addLinkedHashSetBands("Yellow Eye");
        setExample.addLinkedHashSetBands("Swans");
        setExample.removeLinkedHashSetBands("Swans");
        System.out.println("LinkedHashSet: " + setExample.bandsLinkedHashSet);

        setExample.addTreeSet("Yellow Eye");
        setExample.addTreeSet("Mayhem");
        setExample.addTreeSet("Summoning");
        setExample.addTreeSet("Swans");
        setExample.addTreeSet("Dissection");
        setExample.removeTreeSet("Swans");
        System.out.println("TreeSet: " + setExample.bandsTreeSet);
    }
}