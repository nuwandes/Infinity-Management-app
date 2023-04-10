package com.apextech.infinitynewdawn.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apextech.infinitynewdawn.R;
import com.apextech.infinitynewdawn.data.models.WeighmentResponse;

import java.util.ArrayList;
import java.util.List;

public class DailyWeighmentAdapter extends RecyclerView.Adapter<DailyWeighmentAdapter.DailyWeighmentViewHolder> implements Filterable {

    private List<WeighmentResponse> weighmentResponseList;
    private List<WeighmentResponse> getWeighmentResponseListFilter = new ArrayList<>();
    private Context context;

    public void setWeighmentData(List<WeighmentResponse> weighmentResponseList){
        this.weighmentResponseList = weighmentResponseList;
    }

    @NonNull
    @Override
    public DailyWeighmentAdapter.DailyWeighmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View listItem = layoutInflater.inflate(R.layout.daily_weighment_row_item, parent, false);
        return new DailyWeighmentAdapter.DailyWeighmentViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyWeighmentAdapter.DailyWeighmentViewHolder holder, int position) {

        WeighmentResponse weighmentResponse = weighmentResponseList.get(position);

        int division = weighmentResponse.getDivisionId();
        int fieldId = weighmentResponse.getFieldId();
        String internalNo = weighmentResponse.getInternalNo();
        int employeeName = weighmentResponse.getEmployeeId();
        int workCode = weighmentResponse.getWorkCodeId();
        int sessionNo = weighmentResponse.getSessionNo();
        float grossWeight = weighmentResponse.getOriginalGross();
        float moisture = weighmentResponse.getCalculatedMoisture();
        int extraDeduction = weighmentResponse.getAdditionalDeduction();
        int roundedNetWeight = weighmentResponse.getRoundedNetWeight();

        holder.divisionName.setText(String.valueOf(division));
        holder.fieldName.setText(String.valueOf(fieldId));
        holder.empNo.setText(String.valueOf(internalNo));
        holder.empName.setText(String.valueOf(employeeName));
        holder.workCode.setText(String.valueOf(workCode));
        holder.sessionNumber.setText(String.valueOf(sessionNo));
        /*holder.grossWeight.setText(String.valueOf(grossWeight));
        holder.moisture.setText(String.valueOf(moisture));*/
        holder.extraDeduction.setText(String.valueOf(extraDeduction));
        holder.roundedNetWeight.setText(String.valueOf(roundedNetWeight));
    }

    @Override
    public int getItemCount() {
        return weighmentResponseList.size();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
        return filter;
    }

    public class DailyWeighmentViewHolder extends RecyclerView.ViewHolder {

        TextView divisionName, fieldName, empNo, empName, workCode, sessionNumber, grossWeight, moisture, extraDeduction, roundedNetWeight;

        public DailyWeighmentViewHolder(@NonNull View itemView) {
            super(itemView);

            divisionName = itemView.findViewById(R.id.txtDivison_daily_weighment_row_item);
            fieldName = itemView.findViewById(R.id.txtField_daily_weighment_row_item);
            empNo = itemView.findViewById(R.id.txtEmployeeNo_daily_weighment_row_item);
            empName = itemView.findViewById(R.id.txtEmployeeName_daily_weighment_row_item);
            workCode = itemView.findViewById(R.id.txtWorkCode_daily_weighment_row_item);
            sessionNumber = itemView.findViewById(R.id.txtSessionNumber_daily_weighment_row_item);
            grossWeight = itemView.findViewById(R.id.txtGrossWeight_daily_weighment_row_item);
            moisture = itemView.findViewById(R.id.txtStndDeductionTotal_activity_daily_weighment);
            extraDeduction = itemView.findViewById(R.id.txtExtraDeduction_daily_weighment_row_item);
            roundedNetWeight = itemView.findViewById(R.id.txtRoundedNetWeight_daily_weighment_row_item);

        }
    }
}

