package kirin3.jp.listviewexpandable;

// 子アイテムの定義
public class ChildItem {
    private String name = "";             // 名前
    private int resourceId = R.drawable.ic_launcher_foreground;  // アイコンのResource ID. DefaultはLauncherアイコン

    public ChildItem(String name, int id) {
        this.name = name;
        this.resourceId = id;
    }

    public ChildItem(String name) {
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