package com.example.projectfrontend.classKontradiksiMatriks;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectfrontend.R;
import com.example.projectfrontend.classPrinsipalSolusi.PenjelasanPrinsipalSolusi;
import com.example.projectfrontend.classPrinsipalSolusi.PrinsipalSolusi;

import java.util.ArrayList;

public class AdapterCm extends RecyclerView.Adapter<AdapterCm.ViewHolder> {
    private final Context context;
    private final ArrayList<PrinsipalSolusi> listPrinsipalSolusi;
    private final ArrayList<PenjelasanPrinsipalSolusi> listPenjelasanPrinsipalSolusi;
    private final RecyclerViewInterfaceCm recyclerViewInterfaceCm;


    AdapterCm(Context context, ArrayList<PrinsipalSolusi> listPrinsipalSolusi, ArrayList<PenjelasanPrinsipalSolusi> penjelasan_ps, RecyclerViewInterfaceCm recyclerViewInterfaceCm) {
        this.context = context;
        this.listPrinsipalSolusi = listPrinsipalSolusi;
        this.listPenjelasanPrinsipalSolusi = penjelasan_ps;
        this.recyclerViewInterfaceCm = recyclerViewInterfaceCm;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_cm1, parent, false);
        return new ViewHolder(view, listPrinsipalSolusi, listPenjelasanPrinsipalSolusi, recyclerViewInterfaceCm);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCm.ViewHolder holder, int position) {
        holder.id_ps_txt.setText(String.valueOf(listPrinsipalSolusi.get(position).getId()));
        holder.nama_ps_txt.setText((listPrinsipalSolusi.get(position).getNamaIngPs()));
    }

    @Override
    public int getItemCount() {
        return listPrinsipalSolusi.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imbulet, imMinus;
        TextView id_ps_txt, nama_ps_txt, penjelasan_ps_txt;
        Button ilutrasi_ps;
        RelativeLayout containerPenjelasan;


        public ViewHolder(@NonNull View itemView, ArrayList<PrinsipalSolusi> prinsipalSolusi, ArrayList<PenjelasanPrinsipalSolusi> listPenjelasan, RecyclerViewInterfaceCm recyclerViewInterfaceCm) {
            super(itemView);
            imbulet = itemView.findViewById(R.id.circleplus);
            imMinus = itemView.findViewById(R.id.circleminus);
            id_ps_txt = itemView.findViewById(R.id.id_solusiCm);
            nama_ps_txt = itemView.findViewById(R.id.nama_solusiCm);
            penjelasan_ps_txt = itemView.findViewById(R.id.isi_penjelasanSolusi);
            ilutrasi_ps = itemView.findViewById(R.id.button_ilustrasiCm);
            containerPenjelasan = itemView.findViewById(R.id.containerPenjelasan);

            nama_ps_txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = "";
                    if (containerPenjelasan.getVisibility() == View.GONE) {
                        containerPenjelasan.setVisibility(View.VISIBLE);
                        if (imMinus.getVisibility()== View.GONE){
                            imMinus.setVisibility(View.VISIBLE);
                        }

                        PrinsipalSolusi ps = prinsipalSolusi.get(getAdapterPosition());
                        for (PenjelasanPrinsipalSolusi penjelasan: listPenjelasan) {
                            if (ps.getId() == penjelasan.getIdPs()) {
                                text += penjelasan.getPenjelasanIng()+"\n";
                            }
                        }
                        penjelasan_ps_txt.setText(text);
                    } else {
                        containerPenjelasan.setVisibility(View.GONE);
                        imMinus.setVisibility(View.GONE);
                    }
                }
            });

            imbulet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = "";
                    if (containerPenjelasan.getVisibility() == View.GONE) {
                        containerPenjelasan.setVisibility(View.VISIBLE);
                        if (imMinus.getVisibility()== View.GONE){
                            imMinus.setVisibility(View.VISIBLE);
                        }

                        PrinsipalSolusi ps = prinsipalSolusi.get(getAdapterPosition());
                        for (PenjelasanPrinsipalSolusi penjelasan: listPenjelasan) {
                            if (ps.getId() == penjelasan.getIdPs()) {
                                text += penjelasan.getPenjelasanIng()+"\n";
                            }
                        }
                        penjelasan_ps_txt.setText(text);
                    } else {
                        containerPenjelasan.setVisibility(View.GONE);
                        imMinus.setVisibility(View.GONE);
                    }
                }
            });



            ilutrasi_ps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("tombol ilustrasi","berhasil diklik");
                    if (recyclerViewInterfaceCm != null){
                        int pos = getAdapterPosition();

                        int id = Integer.parseInt(id_ps_txt.getText().toString());
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewInterfaceCm.onItemClick(id, nama_ps_txt.getText().toString());
                        }
                    }                }
            });
        }
    }
}
