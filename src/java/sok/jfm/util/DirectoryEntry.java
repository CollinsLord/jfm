package sok.jfm.util;

/**
 * This class represents a directory entry.
 *
 * All the information which is needed by the file manager relating to a
 * dirctory entry should be stored here.
 */
public class DirectoryEntry {
    private String fileName;

    /**
     * Create a new directory entry with the specified file name.
     *
     * @param fileName the file name
     */
    public DirectoryEntry(String fileName) {
        setFilename(fileName);
    }

    /**
     * Get the file name.
     *
     * @return the file name
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Set the file name.
     *
     * @param fileName the file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
