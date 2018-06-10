package kirin3.jp.listviewexpandable;

// グループアイテムの定義
public class GroupItem {
    private String name = "";             // 名前
    private int resourceId = R.drawable.ic_launcher_foreground;  // アイコンのResource ID. DefaultはLauncherアイコン

    public GroupItem(String name, int id) {
        this.name = name;
        this.resourceId = id;
    }

    public GroupItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getResourceId() {
        return resourceId;
    }
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}