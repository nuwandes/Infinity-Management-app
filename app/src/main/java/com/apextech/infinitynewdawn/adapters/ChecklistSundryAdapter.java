package com.apextech.infinitynewdawn.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apextech.infinitynewdawn.R;
import com.apextech.infinitynewdawn.data.models.ChecklistSundryResponse;

import java.util.List;

public class ChecklistSundryAdapter extends RecyclerView.Adapter<ChecklistSundryAdapter.ChecklistSundryViewHolder> {

    private List<ChecklistSundryResponse> checklistSundryResponseList;
    private Context context;

    public void setChecklistSundryData(List<ChecklistSundryResponse> checklistSundryResponseList){
        this.checklistSundryResponseList = checklistSundryResponseList;
    }

    @NonNull
    @Override
    public ChecklistSundryAdapter.ChecklistSundryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View listItem = layoutInflater.inflate(R.layout.checklist_sundry_row_item, parent, false);
        return new ChecklistSundryAdapter.ChecklistSundryViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ChecklistSundryAdapter.ChecklistSundryViewHolder holder, int position) {

        ChecklistSundryResponse checklistSundryResponse = checklistSundryResponseList.get(position);

        int reference = position + 1;
        String field = checklistSundryResponse.getFieldCode() + " / " + checklistSundryResponse.getFieldId();
        String employeeNo = checklistSundryResponse.getEmployeeNumber();
        String employeeName = checklistSundryResponse.getEmployeeName();
        String workType = checklistSundryResponse.getWorkType();
        String workCode = checklistSundryResponse.getWorkCode() + " / " + checklistSundryResponse.getWorkCodeId();
        String checkIn = checklistSundryResponse.getCheckInTime();
        String checkOut = checklistSundryResponse.getCheckOutTime();
        String duration = checklistSundryResponse.getDuration();
        String supervisorName = checklistSundryResponse.getSupervisorName();
        String workName = "Full";

        holder.ref.setText(String.valueOf(reference));
        holder.field.setText(field);
        holder.employeeNo.setText(employeeNo);
        holder.employeeName.setText(employeeName);
        holder.workType.setText(workType);
        holder.workCode.setText(workCode);
        holder.checkIn.setText(checkIn);
        holder.checkOut.setText(checkOut);
        holder.duration.setText(duration);
        holder.supervisorName.setText(supervisorName);
        holder.workName.setText("Full");
    }


    @Override
    public int getItemCount() {
        return checklistSundryResponseList.size();
    }

    static class ChecklistSundryViewHolder extends RecyclerView.ViewHolder {

        TextView ref, field,employeeNo, employeeName, workType, workCode, checkIn, checkOut, duration, supervisorName, workName;

        public ChecklistSundryViewHolder(@NonNull View itemView) {
            super(itemView);

            ref = itemView.findViewById(R.id.txtRef_checklist_sundry_row_item);
            field = itemView.findViewById(R.id.txtField_checklist_sundry_row_item);
            employeeNo = itemView.findViewById(R.id.txtEmployeeNo_checklist_sundry_row_item);
            employeeName = itemView.findViewById(R.id.txtEmployeeName_checklist_sundry_row_item);
            workType = itemView.findViewById(R.id.txtWorkType_checklist_sundry_row_item);
            workCode = itemView.findViewById(R.id.txtWorkCode_checklist_sundry_row_item);
            checkIn = itemView.findViewById(R.id.txtCheckIn_checklist_sundry_row_item);
            checkOut = itemView.findViewById(R.id.txtCheckOut_checklist_sundry_row_item);
            duration = itemView.findViewById(R.id.txtDuration_checklist_sundry_row_item);
            supervisorName = itemView.findViewById(R.id.txtSupervisorName_checklist_sundry_row_item);
            workName = itemView.findViewById(R.id.txtWorkName_checklist_sundry_row_item);
        }
    }
}
