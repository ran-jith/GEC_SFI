package anoop.myprojects.gec_sfi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by anoop on 25/11/16.
 */

public class ViewPagerAdapterInfinity extends FragmentPagerAdapter{

    public static int LOOPS_COUNT = 100;


    ArrayList<Fragment> fragments = new ArrayList<>();


    public void addFragments(Fragment fragments){

       this.fragments.add(fragments);


    }


     public ViewPagerAdapterInfinity(FragmentManager fm){

        super(fm);

    }
    @Override
    public Fragment getItem(int position) {

         System.out.println("Fragment Pos ="+position);
        System.out.println("Fragment count ="+fragments.size());

        if (fragments != null && fragments.size() > 0)
        {
            position = position % fragments.size(); // use modulo for infinite cycling

        }

        return fragments.get(position);


         //return fragments.get(position);
    }

    @Override
    public int getCount() {

        if (fragments!= null && fragments.size() > 0)
        {
            return fragments.size()*LOOPS_COUNT; // simulate infinite by big number of products
        }
        else
        {
            return 1;
        }

    }

    /*@Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = mTitleList.get(position % mActualTitleListSize);
        return title;
    }*/

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int virtualPosition = position % fragments.size();
        return super.instantiateItem(container, virtualPosition);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int virtualPosition = position % fragments.size();
        super.destroyItem(container, virtualPosition, object);
    }
}
