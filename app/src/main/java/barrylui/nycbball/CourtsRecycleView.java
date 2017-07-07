package barrylui.nycbball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class CourtsRecycleView extends AppCompatActivity implements RecycleView.OnFragmentInteractionListener {
    Fragment mContent;
    CourtData cData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courts_recycle_view);

        if (savedInstanceState != null) {
            mContent = getSupportFragmentManager().getFragment(savedInstanceState, "mContent");
        }
        else {
            cData = new CourtData();
            mContent = RecycleView.newInstance(-1);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mContent).addToBackStack(null).commit();
    }

    @Override
    public void onFragmentInteraction(int num) {
        Intent courtdetail = new Intent(this, CourtActivity.class);
        courtdetail.putExtra("position", num);
        startActivity(courtdetail);
        //mContent = RecycleView.newInstance((num));
        //getSupportFragmentManager().beginTransaction().replace(R.id.container, mContent).addToBackStack(null).commit();
    }
}
