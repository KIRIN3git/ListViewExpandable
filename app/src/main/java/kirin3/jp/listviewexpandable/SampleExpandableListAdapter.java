package kirin3.jp.listviewexpandable;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


public class SampleExpandableListAdapter extends BaseExpandableListAdapter {

    private List<GroupItem> groups;
    private List<List<ChildItem>> children;
    private Context context = null;
    private int[] rowId;

    /**
     * Constructor
     */
    public SampleExpandableListAdapter(Context ctx, int[] rowId, List<GroupItem> groups, List<List<ChildItem>> children) {
        this.context = ctx;
        this.groups = groups;
        this.children = children;
        this.rowId = rowId;
    }

    /**
     *
     * @return
     */
    public View getGroupView() {
        // xmlをinflateしてViewを作成する
        View view = LayoutInflater.from(context).inflate(R.layout.group_list, null);
        return view;
    }

    /**
     *
     * @return
     */
    public View getChildView() {
        // xmlをinflateしてViewを作成する
        View view = LayoutInflater.from(context).inflate(R.layout.child_list, null);
        return view;
    }


    public int getRowId(int groupPosition) {
        return rowId[groupPosition];
    }


    @Override
    public Object getGroup(int arg0) {
        return groups.get(arg0);
    }

    @Override
    public int getGroupCount() {
        return children.size();
    }

    @Override
    public long getGroupId(int arg0) {
        return arg0;
    }


    @Override
    public Object getChild(int arg0, int arg1) {
        return children.get(arg0).get(arg1);
    }

    @Override
    public long getChildId(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return arg1;
    }

    @Override
    public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
        // グループのViewオブジェクトを作成
        View groupView = getGroupView();
        TextView textView = (TextView)groupView.findViewById(R.id.text);
        GroupItem dto  = groups.get(arg0);
        textView.setText(dto.getName());

        return groupView;
    }

    @Override
    public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
                             ViewGroup arg4) {
        // 子供のViewオブジェクトを作成
        View childView = getChildView();
        TextView textView = (TextView)childView.findViewById(R.id.text);
        ChildItem dto  = children.get(arg0).get(arg1);
        textView.setText(dto.getName());

        // アイコンの付属（xmlに記載で良いと思われるが・・・）
        Drawable icon = context.getResources().getDrawable(dto.getResourceId());
        int width = (int)(48 * context.getResources().getDisplayMetrics().density + 0.5f);
        icon.setBounds(0, 0, width, width);
        textView.setCompoundDrawables(icon, null, null, null);

        return childView;
    }

    @Override
    public int getChildrenCount(int arg0) {
        return children.get(arg0).size();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        return true;
    }

}