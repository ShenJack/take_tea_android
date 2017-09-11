package com.sjjkk.tearythm.recommand;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.sjjkk.tearythm.R;
import com.sjjkk.tearythm.daily.DailyFragment;
import com.sjjkk.tearythm.data.Data;
import com.sjjkk.tearythm.data.source.remote.TeaRythmRemoteService;
import com.sjjkk.tearythm.view.ExpandableTextView;
import com.sjjkk.tearythm.view.TeaAdapter;
import com.stepstone.stepper.StepperLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecommendFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecommendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecommendFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    List<String > choices = new ArrayList<>();
    private Button button;
    ListView listView;


    private TeaAdapter teaAdapter;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RecommendFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecommendFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecommendFragment newInstance(String param1, String param2) {
        RecommendFragment fragment = new RecommendFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recommand, container, false);
        listView = (ListView) view.findViewById(R.id.recommends);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = (Button) getView().findViewById(R.id.test);
//        ExpandableTextView expandableTextView = (ExpandableTextView) getView().findViewById(R.id.expand_textview);
//        expandableTextView.setText("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog1();
            }
        });


        teaAdapter = new TeaAdapter(getActivity());
        listView.setAdapter(teaAdapter);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    void showDialog1(){
        List<String> ages = new ArrayList<>();
        ages.add("12-18");
        ages.add("18-40");
        ages.add("40-60");
        ages.add("60以上");

        final int[] ageInt = {15,29,50,65};
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("您的年龄阶段为...")
                .setSingleChoiceItems(ages.toArray(new String[ages.size()]), -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choices.add(String.valueOf(ageInt[which]));
                        dialog.cancel();
                        showDialog2();
                    }
                })
                .show();
    }

    private void showDialog2() {
        final List<String> functions = new ArrayList<>();
        functions.add("消脂减肥");
        functions.add("治疗便秘");
        functions.add("预防心血管疾病");
        functions.add("治疗肠胃不适，降火去燥");
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("您期待的功效有...")
                .setSingleChoiceItems(functions.toArray(new String[functions.size()]), -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choices.add(functions.get(which));
                        dialog.cancel();
                        showDialog3();
                    }
                })
                .show();
    }

    private void showDialog3() {
        final List<String> tastes = new ArrayList<>();
        tastes.add("清爽");
        tastes.add("微苦");
        tastes.add("醇厚");
        tastes.add("浓烈");
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("您期望的口味是....")
                .setSingleChoiceItems(tastes.toArray(new String[tastes.size()]), -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choices.add(tastes.get(which));
                        dialog.cancel();
                        submitResult();
                    }
                })
                .show();
    }

    private void submitResult() {
        TeaRythmRemoteService.INSTANCE.getRetrofitInstance()
                .getTeaAnswer(choices.get(0),choices.get(2),choices.get(1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Data>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Data data) {
                        if (data.getResult().size()>0){
                            teaAdapter.setTeas(data.getResult());
                        }
                        else {
                            Snackbar.make(getView(), "没有合适的推荐", Snackbar.LENGTH_LONG)
                                    .setAction("再选一遍", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            showDialog1();
                                        }
                                    }).show();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        choices.clear();
                    }
                });
    }
}
