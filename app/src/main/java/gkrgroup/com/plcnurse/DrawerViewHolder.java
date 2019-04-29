package gkrgroup.com.plcnurse;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import gkrgroup.com.plcnurse.Fragments.AboutUs;
import gkrgroup.com.plcnurse.Fragments.WebViewFragment;

/**
 * Created by AbhiAndroid
 */

public class DrawerViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    ImageView icon;

    public DrawerViewHolder(final Context context, View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        icon = (ImageView) itemView.findViewById(R.id.titleIcon);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDrawerAdapter.selected_item = getPosition();
                MainActivity.title.setText(MainActivity.menuTitles.get(getPosition()));
                Bundle bundle = new Bundle();
                WebViewFragment webViewFragment = new WebViewFragment();
                switch (getPosition()) {

                    case 0:
                        bundle.putString("url", Config.homeUrl);
                        webViewFragment.setArguments(bundle);
                        ((MainActivity) context).loadFragment(webViewFragment, false,"webViewFragment");
                        break;
                    case 1:
                        bundle.putString("url",Config.storeUrl );
                        webViewFragment.setArguments(bundle);
                        ((MainActivity) context).loadFragment(webViewFragment, false,"webViewFragment");
                        break;
                    case 2:
                        bundle.putString("url", Config.serviceUrl);
                        webViewFragment.setArguments(bundle);
                        ((MainActivity) context).loadFragment(webViewFragment, false,"webViewFragment");
                        break;
                    case 3:
                        bundle.putString("url", Config.supportUrl);
                        webViewFragment.setArguments(bundle);
                        ((MainActivity) context).loadFragment(webViewFragment, false,"webViewFragment");
                        break;
                    case 4:
                        ((MainActivity) context).loadFragment(new AboutUs(), false);
                        break;

                    case 5:
                        bundle.putString("url", Config.contactUrl);
                        webViewFragment.setArguments(bundle);
                        ((MainActivity) context).loadFragment(webViewFragment, false,"webViewFragment");
                        break;


                }
                MainActivity.customDrawerAdapter.notifyDataSetChanged();
                MainActivity.drawerLayout.closeDrawers();

            }
        });
    }
}
