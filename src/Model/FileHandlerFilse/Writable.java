package Model.FileHandlerFilse;

public interface Writable {
    void save(Object familyTree, String filePath);
    Object load(String Path);
}