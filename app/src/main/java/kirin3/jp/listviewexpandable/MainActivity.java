package kirin3.jp.listviewexpandable;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */

    List<GroupItem> mGroups;
    List<List<ChildItem>> mChildlen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListView listView = (ExpandableListView)findViewById(R.id.expandable_list);
        int[] rowId = {0,1};
        listView.setAdapter(new SampleExpandableListAdapter(this, rowId, createGroupItemList(), createChildrenItemList()));


        // 親要素クリック処理（注意：ほかにクリック要素があると使えない）
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View view,
                                        int groupPosition, long id) {

                // アラート表示
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("クリック！")
                        .setMessage(mGroups.get(groupPosition).getName())
                        .setPositiveButton("OK", null)
                        .show();

                return false;
            }
        });


        // 子要素クリック処理（注意：ほかにクリック要素があると使えない）
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view,
                                        int groupPosition, int childPosition, long id) {

                // アラート表示
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("クリック！")
                        .setMessage(mChildlen.get(groupPosition).get(childPosition).getName())
                        .setPositiveButton("OK", null)
                        .show();

                return false;
            }
        });
    }

    /**
     *
     * @return
     */
    private List<GroupItem> createGroupItemList() {
        mGroups = new ArrayList<GroupItem>();
        mGroups.add(new GroupItem("いぬグループ"));
        mGroups.add(new GroupItem("ねこグループ"));
        return mGroups;
    }

    /**
     *
     * @return
     */
    private List<List<ChildItem>> createChildrenItemList() {
        List<ChildItem> child = new ArrayList<ChildItem>();
        child.add(new ChildItem("ねこ１"));
        child.add(new ChildItem("ねこ２"));
        child.add(new ChildItem("コーギー１"));
        child.add(new ChildItem("コーギー２"));
        child.add(new ChildItem("しばいぬ１"));

        List<ChildItem> child2 = new ArrayList<ChildItem>();
        child2.add(new ChildItem("猫１", R.drawable.ic_launcher_background));
        child2.add(new ChildItem("猫２", R.drawable.ic_launcher_background));
        child2.add(new ChildItem("コーギー１", R.drawable.ic_launcher_background));
        child2.add(new ChildItem("コーギー２", R.drawable.ic_launcher_background));
        child2.add(new ChildItem("柴犬", R.drawable.ic_launcher_background));

        mChildlen = new ArrayList<List<ChildItem>>();
        mChildlen.add(child);
        mChildlen.add(child2);

        return mChildlen;
    }
}