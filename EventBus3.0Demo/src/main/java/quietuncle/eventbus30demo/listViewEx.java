package quietuncle.eventbus30demo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * Copyright (c) 2017. 深圳联友科技. All rights reserved
 * Created by lpc on 2018/1/23.
 */

public class listViewEx extends ListView {

    public listViewEx(Context context) {
        this(context,null);
    }

    public listViewEx(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public listViewEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }


}
