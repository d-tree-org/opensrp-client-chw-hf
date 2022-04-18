package org.smartregister.chw.hf.domain.anc_reports;

import org.json.JSONException;
import org.json.JSONObject;
import org.smartregister.chw.hf.dao.ReportDao;
import org.smartregister.chw.hf.domain.ReportObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AncMonthlyReportObject extends ReportObject {
    private final Date reportDate;
    private final List<String> indicatorCodes = new ArrayList<>();

    public AncMonthlyReportObject(Date reportDate) {
        super(reportDate);
        this.reportDate = reportDate;
        setIndicatorCodes(indicatorCodes);
    }

    public void setIndicatorCodes(List<String> indicatorCodes) {
        indicatorCodes.add("2a-10-14");
        indicatorCodes.add("2a-15-19");
        indicatorCodes.add("2a-20-24");
        indicatorCodes.add("2a-25-29");
        indicatorCodes.add("2a-30-34");
        indicatorCodes.add("2a-35+");
        indicatorCodes.add("2b-10-14");
        indicatorCodes.add("2b-15-19");
        indicatorCodes.add("2b-20-24");
        indicatorCodes.add("2b-25-29");
        indicatorCodes.add("2b-30-34");
        indicatorCodes.add("2b-35+");
        indicatorCodes.add("2c-10-14");
        indicatorCodes.add("2c-15-19");
        indicatorCodes.add("2c-20-24");
        indicatorCodes.add("2c-25-29");
        indicatorCodes.add("2c-30-34");
        indicatorCodes.add("2c-35+");
        indicatorCodes.add("2d-10-14");
        indicatorCodes.add("2d-15-19");
        indicatorCodes.add("2d-20-24");
        indicatorCodes.add("2d-25-29");
        indicatorCodes.add("2d-30-34");
        indicatorCodes.add("2d-35+");
        indicatorCodes.add("2e-10-14");
        indicatorCodes.add("2e-15-19");
        indicatorCodes.add("2e-20-24");
        indicatorCodes.add("2e-25-29");
        indicatorCodes.add("2e-30-34");
        indicatorCodes.add("2e-35+");
        indicatorCodes.add("3-10-14");
        indicatorCodes.add("3-15-19");
        indicatorCodes.add("3-20-24");
        indicatorCodes.add("3-25-29");
        indicatorCodes.add("3-30-34");
        indicatorCodes.add("3-35+");
        indicatorCodes.add("4a-10-14");
        indicatorCodes.add("4a-15-19");
        indicatorCodes.add("4a-20-24");
        indicatorCodes.add("4a-25-29");
        indicatorCodes.add("4a-30-34");
        indicatorCodes.add("4a-35+");
        indicatorCodes.add("4b-10-14");
        indicatorCodes.add("4b-15-19");
        indicatorCodes.add("4c-35+");
        indicatorCodes.add("4d-10-14");
        indicatorCodes.add("4d-15-19");
        indicatorCodes.add("4d-20-24");
        indicatorCodes.add("4d-25-29");
        indicatorCodes.add("4d-30-34");
        indicatorCodes.add("4d-35+");
        indicatorCodes.add("4e-10-14");
        indicatorCodes.add("4e-15-19");
        indicatorCodes.add("4e-20-24");
        indicatorCodes.add("4e-25-29");
        indicatorCodes.add("4e-30-34");
        indicatorCodes.add("4e-35+");
        indicatorCodes.add("4f-10-14");
        indicatorCodes.add("4f-15-19");
        indicatorCodes.add("4f-20-24");
        indicatorCodes.add("4f-25-29");
        indicatorCodes.add("4f-30-34");
        indicatorCodes.add("4f-35+");
        indicatorCodes.add("4g-10-14");
        indicatorCodes.add("4g-15-19");
        indicatorCodes.add("4g-20-24");
        indicatorCodes.add("4g-25-29");
        indicatorCodes.add("4g-30-34");
        indicatorCodes.add("4g-35+");
        indicatorCodes.add("4h-10-14");
        indicatorCodes.add("4h-15-19");
        indicatorCodes.add("4h-20-24");
        indicatorCodes.add("4h-25-29");
        indicatorCodes.add("4h-30-34");
        indicatorCodes.add("4h-35+");
        indicatorCodes.add("4i-10-14");
        indicatorCodes.add("4i-15-19");
        indicatorCodes.add("4i-20-24");
        indicatorCodes.add("4i-25-29");
        indicatorCodes.add("4i-30-34");
        indicatorCodes.add("4i-35+");
        indicatorCodes.add("4j-10-14");
        indicatorCodes.add("4j-15-19");
        indicatorCodes.add("4j-20-24");
        indicatorCodes.add("4j-25-29");
        indicatorCodes.add("4j-30-34");
        indicatorCodes.add("4j-35+");
        indicatorCodes.add("4k-10-14");
        indicatorCodes.add("4k-15-19");
        indicatorCodes.add("4k-20-24");
        indicatorCodes.add("4k-25-29");
        indicatorCodes.add("4k-30-34");
        indicatorCodes.add("4k-35+");
        indicatorCodes.add("4l-10-14");
        indicatorCodes.add("4l-15-19");
        indicatorCodes.add("4l-20-24");
        indicatorCodes.add("4l-25-29");
        indicatorCodes.add("4l-30-34");
        indicatorCodes.add("4l-35+");
        indicatorCodes.add("4m-10-14");
        indicatorCodes.add("4m-15-19");
        indicatorCodes.add("4m-20-24");
        indicatorCodes.add("4m-25-29");
        indicatorCodes.add("4m-30-34");
        indicatorCodes.add("4m-35+");
        indicatorCodes.add("4n-10-14");
        indicatorCodes.add("4n-15-19");
        indicatorCodes.add("4n-20-24");
        indicatorCodes.add("4n-25-29");
        indicatorCodes.add("4n-30-34");
        indicatorCodes.add("4n-35+");
        indicatorCodes.add("4o-10-14");
        indicatorCodes.add("4o-15-19");
        indicatorCodes.add("4o-20-24");
        indicatorCodes.add("4o-25-29");
        indicatorCodes.add("4o-30-34");
        indicatorCodes.add("4o-35+");
        indicatorCodes.add("4p-10-14");
        indicatorCodes.add("4p-15-19");
        indicatorCodes.add("4p-20-24");
        indicatorCodes.add("4p-25-29");
        indicatorCodes.add("4p-30-34");
        indicatorCodes.add("4p-35+");
        indicatorCodes.add("4q-10-14");
        indicatorCodes.add("4q-15-19");
        indicatorCodes.add("4q-20-24");
        indicatorCodes.add("4q-25-29");
        indicatorCodes.add("4q-30-34");
        indicatorCodes.add("4q-35+");
        indicatorCodes.add("4r-10-14");
        indicatorCodes.add("4r-15-19");
        indicatorCodes.add("4r-20-24");
        indicatorCodes.add("4r-25-29");
        indicatorCodes.add("4r-30-34");
        indicatorCodes.add("4r-35+");
        indicatorCodes.add("5a-10-14");
        indicatorCodes.add("5a-15-19");
        indicatorCodes.add("5a-20-24");
        indicatorCodes.add("5a-25-29");
        indicatorCodes.add("5a-30-34");
        indicatorCodes.add("5a-35+");
        indicatorCodes.add("5b-10-14");
        indicatorCodes.add("5b-15-19");
        indicatorCodes.add("5b-20-24");
        indicatorCodes.add("5b-25-29");
        indicatorCodes.add("5b-30-34");
        indicatorCodes.add("5b-35+");
        indicatorCodes.add("5c-10-14");
        indicatorCodes.add("5c-15-19");
        indicatorCodes.add("5c-20-24");
        indicatorCodes.add("5c-25-29");
        indicatorCodes.add("5c-30-34");
        indicatorCodes.add("5c-35+");
        indicatorCodes.add("5d-10-14");
        indicatorCodes.add("5d-15-19");
        indicatorCodes.add("5d-20-24");
        indicatorCodes.add("5d-25-29");
        indicatorCodes.add("5d-30-34");
        indicatorCodes.add("5d-35+");
        indicatorCodes.add("5e-10-14");
        indicatorCodes.add("5e-15-19");
        indicatorCodes.add("5e-20-24");
        indicatorCodes.add("5f-10-14");
        indicatorCodes.add("5f-15-19");
        indicatorCodes.add("5f-20-24");
        indicatorCodes.add("5f-25-29");
        indicatorCodes.add("5f-30-34");
        indicatorCodes.add("5f-35+");
        indicatorCodes.add("5g-10-14");
        indicatorCodes.add("5g-15-19");
        indicatorCodes.add("5g-20-24");
        indicatorCodes.add("5g-25-29");
        indicatorCodes.add("5g-30-34");
        indicatorCodes.add("5g-35+");
        indicatorCodes.add("5f-10-14");
        indicatorCodes.add("5f-15-19");
        indicatorCodes.add("5f-20-24");
        indicatorCodes.add("5f-25-29");
        indicatorCodes.add("5f-30-34");
        indicatorCodes.add("5f-35+");
        indicatorCodes.add("5h-10-14");
        indicatorCodes.add("5h-15-19");
        indicatorCodes.add("5h-20-24");
        indicatorCodes.add("5h-25-29");
        indicatorCodes.add("5h-30-34");
        indicatorCodes.add("5h-35+");
        indicatorCodes.add("5i-10-14");
        indicatorCodes.add("5i-15-19");
        indicatorCodes.add("5i-20-24");
        indicatorCodes.add("5i-25-29");
        indicatorCodes.add("5i-30-34");
        indicatorCodes.add("5i-35+");
        indicatorCodes.add("5j-10-14");
        indicatorCodes.add("5j-15-19");
        indicatorCodes.add("5j-20-24");
        indicatorCodes.add("5j-25-29");
        indicatorCodes.add("5j-30-34");
        indicatorCodes.add("5j-35+");
        indicatorCodes.add("5k-10-14");
        indicatorCodes.add("5k-15-19");
        indicatorCodes.add("5k-20-24");
        indicatorCodes.add("5k-25-29");
        indicatorCodes.add("5k-30-34");
        indicatorCodes.add("5k-35+");
        indicatorCodes.add("5l-10-14");
        indicatorCodes.add("5l-15-19");
        indicatorCodes.add("5l-20-24");
        indicatorCodes.add("5l-25-29");
        indicatorCodes.add("5l-30-34");
        indicatorCodes.add("5l-35+");
        indicatorCodes.add("5m-10-14");
        indicatorCodes.add("5m-15-19");
        indicatorCodes.add("5m-20-24");
        indicatorCodes.add("5m-25-29");
        indicatorCodes.add("5m-30-34");
        indicatorCodes.add("5m-35+");
        indicatorCodes.add("5n-10-14");
        indicatorCodes.add("5n-15-19");
        indicatorCodes.add("5n-20-24");
        indicatorCodes.add("5n-25-29");
        indicatorCodes.add("5n-30-34");
        indicatorCodes.add("5n-35+");
        indicatorCodes.add("5o-10-14");
        indicatorCodes.add("5o-15-19");
        indicatorCodes.add("5o-20-24");
        indicatorCodes.add("5o-25-29");
        indicatorCodes.add("5o-30-34");
        indicatorCodes.add("5o-35+");
        indicatorCodes.add("5p-10-14");
        indicatorCodes.add("5p-15-19");
        indicatorCodes.add("5p-20-24");
        indicatorCodes.add("6b-10-14");
        indicatorCodes.add("6b-15-19");
        indicatorCodes.add("6b-20-24");
        indicatorCodes.add("6b-25-29");
        indicatorCodes.add("6b-30-34");
        indicatorCodes.add("6b-35+");
        indicatorCodes.add("6c-10-14");
        indicatorCodes.add("6c-15-19");
        indicatorCodes.add("6c-20-24");
        indicatorCodes.add("6c-25-29");
        indicatorCodes.add("6c-30-34");
        indicatorCodes.add("6c-35+");
        indicatorCodes.add("6d-10-14");
        indicatorCodes.add("6d-15-19");
        indicatorCodes.add("6d-20-24");
        indicatorCodes.add("6d-25-29");
        indicatorCodes.add("6d-30-34");
        indicatorCodes.add("6d-35+");
        indicatorCodes.add("6e-10-14");
        indicatorCodes.add("6e-15-19");
        indicatorCodes.add("6e-20-24");
        indicatorCodes.add("6e-25-29");
        indicatorCodes.add("6e-30-34");
        indicatorCodes.add("6e-35+");
        indicatorCodes.add("6f-10-14");
        indicatorCodes.add("6f-15-19");
        indicatorCodes.add("6f-20-24");
        indicatorCodes.add("6f-25-29");
        indicatorCodes.add("6f-30-34");
        indicatorCodes.add("6f-35+");
        indicatorCodes.add("7-10-14");
        indicatorCodes.add("7-15-19");
        indicatorCodes.add("7-20-24");
        indicatorCodes.add("7-25-29");
        indicatorCodes.add("7-30-34");
        indicatorCodes.add("7-35+");
        indicatorCodes.add("8-10-14");
        indicatorCodes.add("8-15-19");
        indicatorCodes.add("8-20-24");
        indicatorCodes.add("8-25-29");
        indicatorCodes.add("8-30-34");
        indicatorCodes.add("8-35+");
        indicatorCodes.add("9-10-14");
        indicatorCodes.add("9-15-19");
        indicatorCodes.add("9-20-24");
        indicatorCodes.add("9-25-29");
        indicatorCodes.add("9-30-34");
        indicatorCodes.add("9-35+");
        indicatorCodes.add("10-10-14");
        indicatorCodes.add("10-15-19");
        indicatorCodes.add("10-20-24");
        indicatorCodes.add("10-25-29");
        indicatorCodes.add("10-30-34");
        indicatorCodes.add("10-35+");
        indicatorCodes.add("11-10-14");
        indicatorCodes.add("11-15-19");
        indicatorCodes.add("11-20-24");
        indicatorCodes.add("11-25-29");
        indicatorCodes.add("11-30-34");
        indicatorCodes.add("11-35+");
    }

    @Override
    public JSONObject getIndicatorData() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        for (String indicatorCode : indicatorCodes) {
            jsonObject.put(indicatorCode, ReportDao.getReportPerIndicatorCode(indicatorCode, reportDate));
        }
        return jsonObject;
    }
}
