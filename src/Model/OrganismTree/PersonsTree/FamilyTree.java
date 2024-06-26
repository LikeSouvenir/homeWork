package Model.OrganismTree.PersonsTree;
import Model.OrganismTree.OrganismeTree;
import Model.Organisms.Mammals.Persons.Comporators.ComporatorByName;
import Model.Organisms.Mammals.Persons.Person;

import java.util.*;

public class FamilyTree<T extends Person> extends OrganismeTree<T> {

    //конструкторы
    public FamilyTree (String familyName) {
        this.familyName = familyName;
        tree = new ArrayList<T>();
    }
    public FamilyTree() {
        this("default");
    }

    //методы

    public String getAllFamily() {
        String out = "";
        for (T somePers : tree) {
            out += somePers;
        }
        return out;
    }
    public Person getFullPerson (int index) {
        if (index < tree.size())
                return tree.get(index);
        return null;
    }
    public HashMap<Integer, T> getPersonOnSurname (String name) {
        HashMap<Integer, T> coincidences = new HashMap<Integer, T>();
        for (T somePers : tree) {
            if (somePers.getName().split(" ").equals(name))
                coincidences.put(somePers.getId(), somePers);
        }
        return coincidences;
    }
    @Override
    public Iterator iterator() {
        return tree.iterator();
    }
    public void sortByName() {
        Collections.sort(tree, new ComporatorByName());
    }
    public void sortByBirthday() {
        Collections.sort(tree,
                Comparator.comparing(T::getBirthday));
                //(o1, o2) -> o1.getBirthday().compareTo(o2.getBirthday());
    }

    public int size() {
        return tree.size();
    }
    public T get(int index) {
        return tree.get(index);
    }
}
