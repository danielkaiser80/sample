package com.efass.download.xmlModels;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data

public class XmlParameters {
    private List<String> codes;
    private Class<?> daoClass;
    private List<GenericXml> genericXmls;
    private String prefix;
    private List<String> result;
    private String reportName;
    private boolean isSpecial;
    private boolean isUniquePrefixT;
    private boolean isUniqueReportWithPrefix;
    private boolean isSpecialWithPrefix;
    private boolean isNoneSpecialWithPrefix;
    private boolean isUniqueReportWithPrefix_400;
    private boolean isSpecialReportWithPrefix_400;
    private boolean isUniqueReportWithPrefix_450;
    private boolean isSpecialReportWithPrefix_450;
    private boolean isSpecialQstdr2;
    private boolean isSpecialMstdr2;
    private boolean isSkipRows;
    private List<String> skipRows;
    private boolean isSkipColumns;
    private List<Integer> skipColumns;
    private List<String> colName;
    private boolean isIdPresent;

}
