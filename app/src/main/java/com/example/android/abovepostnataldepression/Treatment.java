package com.example.android.abovepostnataldepression;

/**
 * Created by bolaadeyeyeomisade on 31/08/2017.
 */

public class Treatment {


    // Labels table name
    public static final String TABLE = "Treatment";

    // Labels Table Columns names
    public static final String KEY_TreatmentID = "TreatmentId";
    public static final String KEY_TreatmentName = "TreatmentName";
    public static final String KEY_TreatmentType = "TreatmentType";
    public static final String KEY_TreatmentNumber = "TreatmentNumber";

    // property help us to keep data
    public int treatment_ID;
    public String editTextTreatmentName;
    public String editTextTreatmentType;
    public int editTextTreatmentNumber;

    public int getTreatment_ID() {
        return treatment_ID;
    }

    public void setTreatment_ID(int treatment_ID) {
        this.treatment_ID = treatment_ID;
    }

    public int getEditTextTreatmentNumber() {
        return editTextTreatmentNumber;
    }

    public void setEditTextTreatmentNumber(int editTextTreatmentNumber) {
        this.editTextTreatmentNumber = editTextTreatmentNumber;
    }

    public String getEditTextTreatmentName() {
        return editTextTreatmentName;
    }

    public void setEditTextTreatmentName(String editTextTreatmentName) {
        this.editTextTreatmentName = editTextTreatmentName;
    }

    public String getEditTextTreatmentType() {
        return editTextTreatmentType;
    }

    public void setEditTextTreatmentType(String editTextTreatmentType) {
        this.editTextTreatmentType = editTextTreatmentType;
    }
}
