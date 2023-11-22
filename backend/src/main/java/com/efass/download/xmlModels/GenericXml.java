package com.efass.download.xmlModels;

public class GenericXml {
	public String ITEMCODE;
	public String ROW;
	public String VALUE;

	public GenericXml(String ITEMCODE, String ROW, String VALUE) {
		this.ITEMCODE = ITEMCODE;
		this.ROW = ROW;
		this.VALUE = VALUE;
	}

	public static void writeIntoXmlFormat(XmlParameters xmlParameters) {

		if (xmlParameters.isSpecial()) {
			writeIntoSpecialXmlFormat(xmlParameters);
			return;
		}

		if (xmlParameters.isSpecialWithPrefix()) {
			writeIntoSpecialXmlFormatWithPrefix(xmlParameters);
			return;
		}
		if (xmlParameters.isNoneSpecialWithPrefix()) {
			writeIntoNoneSpecialXmlFormatWithPrefix(xmlParameters);
			return;
		}
		if (xmlParameters.isUniquePrefixT()) {
			writeIntoSpecialXmlFormatWithUniquePrefix(xmlParameters);
			return;
		}

		if (xmlParameters.isUniqueReportWithPrefix()) {
			writeIntoUniquePrefix(xmlParameters);
			return;
		}

		if (xmlParameters.isUniqueReportWithPrefix_400()) {
			writeIntoNoneSpecialXmlFormatWithPrefix_400(xmlParameters);
			return;
		}
        if (xmlParameters.isSpecialReportWithPrefix_400()) {
            writeIntoSpecialXmlFormatXmlFormatWithPrefix_400(xmlParameters);
            return;
        }
		if (xmlParameters.isUniqueReportWithPrefix_450()) {
			writeIntoNoneSpecialXmlFormatWithPrefix_400(xmlParameters);
			return;
		}

        if (xmlParameters.isSpecialReportWithPrefix_450()) {
            writeIntoSpecialXmlFormatXmlFormatWithPrefix_400(xmlParameters);
            return;
        }
		if (xmlParameters.isSpecialQstdr2()) {
			writeIntoSpecialXmlFormatWithPrefixQstdr(xmlParameters);
			return;
		}

        if (xmlParameters.isSpecialMstdr2()) {
            writeIntoSpecialXmlFormatWithPrefixMstdr(xmlParameters);
            return;
        }

		int length = xmlParameters.getDaoClass().getFields().length - 1;
		String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".C";
		int row = -1;
		int column = 0;

		for (int i = 0; i < xmlParameters.getResult().size(); i++) {
			if (i % length == 0) {
				column = 0;
			}
			column++;
			if (i % length == 0) {
				++row;
			}
			xmlParameters.getGenericXmls()
					.add(new GenericXml(itemCode + column, row + "", xmlParameters.getResult().get(i)));
		}
	}

	private static void writeIntoSpecialXmlFormat(XmlParameters xmlParameters) {
		int length = xmlParameters.getDaoClass().getFields().length - 2;
		String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".C";

		int column = 0;
		int dividingFactor;
		if (length > 1) {
			dividingFactor = length - 1;
		} else {
			dividingFactor = length;
		}

		// int row = -1;

		for (int i = 0; i < xmlParameters.getResult().size(); i++) {
			if (i % dividingFactor == 0) {
				column = 0;
			}

			column++;

			int index = i / dividingFactor;
			xmlParameters.getGenericXmls()
					.add(new GenericXml(itemCode + column + "." + xmlParameters.getCodes().get(index),
							Math.abs(index) + "", xmlParameters.getResult().get(i)));

		}

	}

	private static void writeIntoSpecialXmlFormatWithPrefix(XmlParameters xmlParameters) {
		int length = xmlParameters.getDaoClass().getFields().length - 2;
		String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".C";
		int column = 0;
		String itemCode2 = "";

		// dividing factor is the total number of parameters in the Data Access Object
		// (DAO)
		// aside id, code and item description.

		int dividingFactor;
		if (length > 1) {
			dividingFactor = length - 1;
		} else {
			dividingFactor = length;
		}

		for (int i = 0; i < xmlParameters.getResult().size(); i++) {
			if (i % dividingFactor == 0) {
				column = 0;
			}

			if (column < 9) {
				itemCode2 = itemCode + "0";
			}
			column++;

			int index = i / dividingFactor;

			if (xmlParameters.isSkipRows()
					&& xmlParameters.getSkipRows().contains(xmlParameters.getCodes().get(index))) {
				column = 1;
				xmlParameters.getGenericXmls()
						.add(new GenericXml(itemCode2 + column + "." + xmlParameters.getCodes().get(index),
								Math.abs(index) + "", xmlParameters.getResult().get(i)));
				itemCode2 = itemCode;
				i = i + 3;
				continue;
			}

			xmlParameters.getGenericXmls()
					.add(new GenericXml(itemCode2 + column + "." + xmlParameters.getCodes().get(index),
							Math.abs(index) + "", xmlParameters.getResult().get(i)));
			itemCode2 = itemCode;
		}

	}

	private static void writeIntoNoneSpecialXmlFormatWithPrefix(XmlParameters xmlParameters) {

		int length = xmlParameters.getDaoClass().getFields().length - 1;
		if (xmlParameters.isIdPresent()) {
			length = xmlParameters.getDaoClass().getFields().length;
		}
		String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".C";
		int row = -1;
		int column = 0;
		String itemCode2 = "";
		for (int i = 0; i < xmlParameters.getResult().size(); i++) {
			if (i % length == 0) {
				column = 0;
			}
			if (column < 9) {
				itemCode2 = itemCode + "0";
			}

			if (xmlParameters.isSkipColumns() && xmlParameters.getSkipColumns().contains(i)) {
				column++;
			}

			if (i % length == 0) {
				++row;
			}
			column++;
			xmlParameters.getGenericXmls()
					.add(new GenericXml(itemCode2 + column, row + "", xmlParameters.getResult().get(i)));
			itemCode2 = itemCode;
		}
	}

	private static void writeIntoSpecialXmlFormatWithUniquePrefix(XmlParameters xmlParameters) {
		int length = xmlParameters.getDaoClass().getFields().length - 2;
		String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".T";
		int column = 0;

		// dividing factor is the total number of parameters in the Data Access Object
		// (DAO)
		// aside id, code and item description.
		int dividingFactor;
		if (length > 1) {
			dividingFactor = length - 1;
		} else {
			dividingFactor = length;
		}

		for (int i = 0; i < xmlParameters.getResult().size(); i++) {
			if (i % dividingFactor == 0) {
				column = 0;
			}
			column++;

			int index = i / dividingFactor;
			xmlParameters.getGenericXmls()
					.add(new GenericXml(itemCode + column + "." + xmlParameters.getCodes().get(index),
							Math.abs(index) + "", xmlParameters.getResult().get(i)));
		}

	}

	private static void writeIntoUniquePrefix(XmlParameters xmlParameters) {
		int length = xmlParameters.getDaoClass().getFields().length - 1;
		String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".T";
		int row = -1;
		int column = 0;
		String itemCode2 = "";
		for (int i = 0; i < xmlParameters.getResult().size(); i++) {
			if (i % length == 0) {
				column = 0;
			}
			if (column < 9) {
				itemCode2 = itemCode + "0";
			}

			column++;
			if (i % length == 0) {
				++row;
			}

			if (xmlParameters.isSkipColumns() && xmlParameters.getSkipColumns().contains(i)) {
				column++;
			}

			if (i % length == 0) {
				++row;
			}
			column++;

			xmlParameters.getGenericXmls()
					.add(new GenericXml(itemCode2 + column, row + "", xmlParameters.getResult().get(i)));
			itemCode2 = itemCode;
		}
	}

    /* QDFIR 400 and 450 loops starts here */

    private static void writeIntoNoneSpecialXmlFormatWithPrefix_400(XmlParameters xmlParameters) {

        int length = xmlParameters.getDaoClass().getFields().length - 1;
        if (xmlParameters.isIdPresent()) {
            length = xmlParameters.getDaoClass().getFields().length;
        }
        String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".C";
        int row = 0;
        int row1 = -1;
        int column = 0;
        String itemCode2 = "";


        for (int i = 0; i < xmlParameters.getResult().size(); i++) {
            if (i % length == 0) {
                column = 0;
            }
            if (column < 9) {
                itemCode2 = itemCode + "0";
            }

            if (xmlParameters.isSkipColumns() && xmlParameters.getSkipColumns().contains(i)) {
                column++;
            }

            if (i % length == 0) {
                ++row1;
            }

            column++;

            xmlParameters.getGenericXmls().add(new GenericXml(addTprefix(itemCode2, row1 + 1) + skipColumn(column),
                row + "", xmlParameters.getResult().get(i)));
            itemCode2 = itemCode;
        }
    }




    /* MDFIR400 and MDFIR450 loops starts here */
    private static void writeIntoSpecialXmlFormatXmlFormatWithPrefix_400(XmlParameters xmlParameters) {
        int length = xmlParameters.getDaoClass().getFields().length - 1;
        String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".C";
        int row = 0;
        int row1 = -1;
        int column = 0;
        String itemCode2 = "";

        for (int i = 0; i < length; i++) {
            if (i % length == 0) {
				column = 0;
			}

            if (column < 9) {
                itemCode2 = itemCode + "";
            }
            ++row;
            int resultSizeDividedByLength = xmlParameters.getResult().size() / length;
            if (xmlParameters.isSkipRows() && xmlParameters.getSkipRows().contains(String.valueOf(row-1))) {
                i = i -1;
                row = row + 1;
                continue;
            }
            for (int j = 0; j < resultSizeDividedByLength; j++) {
                column++;
                row = j;
                int index = j * length + i;

           //     xmlParameters.getGenericXmls().add(new GenericXml(addTprefix(itemCode2, i+1, row) + (row + 1) ,
               //     0 + "", xmlParameters.getResult().get(index)));
                xmlParameters.getGenericXmls().add(new GenericXml(addTprefix(itemCode2, i+1, row) + skipRow(row+1),
                     0 + "", xmlParameters.getResult().get(index)));

                itemCode2 = itemCode;
            }
        }
    }


//working with columns
//	private static void writeIntoSpecialXmlFormatXmlFormatWithPrefix_400(XmlParameters xmlParameters) {
//
//		int length = xmlParameters.getDaoClass().getFields().length - 1;
//		if (xmlParameters.isIdPresent()) {
//			length = xmlParameters.getDaoClass().getFields().length;
//		}
//		String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".C";
//		int row = 0;
//		int row1 = -1;
//		int column = 0;
//		String itemCode2 = "";
//
//		for (int i = 0; i < xmlParameters.getResult().size(); i++) {
//			if (i % length == 0) {
//				column = 0;
//			}
//			if (column < 9) {
//				itemCode2 = itemCode + "0";
//			}
//
//			if (xmlParameters.isSkipColumns() && xmlParameters.getSkipColumns().contains(i)) {
//				column++;
//			}
//
//			if (i % length == 0) {
//				++row1;
//			}
//
//			column++;
//
//			xmlParameters.getGenericXmls().add(new GenericXml(addTprefix(itemCode2, row1 + 1) + skipColumn(column),
//					row + "", xmlParameters.getResult().get(i)));
//			itemCode2 = itemCode;
//		}
//	}

    private static String addTprefix(String columnPrefix, int rowNumber, int row) {
        String s = "0";
        if (row >= 9) {s = "";}
        return columnPrefix.replace(".C", ".T" + rowNumber + ".C" + s);
    }

    private static String addTprefix(String columnPrefix, int rowNumber) {
        return columnPrefix.replace(".C", ".T" + rowNumber + ".C");
    }


	private static int skipColumn(int columnNumber) {
		if (columnNumber == 13) {
			return 14;
		}
		return columnNumber;

	}


    private static int skipRow(int rowNumber) {
        if (rowNumber == 13) {
            return 14;
        }
        return rowNumber;

    }

	private static void writeIntoSpecialXmlFormatWithPrefixQstdr(XmlParameters xmlParameters)
   {
		int length = xmlParameters.getDaoClass().getFields().length ;
		String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".C";
		int row = -1;
		int column = 0;
		String itemCode2 = "";

		int dividingFactor;
		if (length > 1) {
			dividingFactor = length - 1;
		} else {
			dividingFactor = length;
		}

		for (int i = 0; i < xmlParameters.getResult().size(); i++) {
			if (i % length == 0) {
				column = 0;
			}

			if (column < 9) {
				itemCode2 = itemCode + "";
			}

			if (xmlParameters.isSkipColumns() && xmlParameters.getSkipColumns().contains(i)) {
				//System.out.println("Skipping :" + i);
				column++;
				continue;
			}else if(xmlParameters.isSkipColumns() && xmlParameters.getSkipColumns().contains(i) && i % length == 0) {
				//System.out.println("Previuos Row Ends Here And Now:");
				++row;
				int newColumn;
				for (int x = 0; x < xmlParameters.getSkipColumns().size(); x++) {
					newColumn = xmlParameters.getSkipColumns().get(x) + 24;
					xmlParameters.getSkipColumns().set(x, newColumn);
				}
				column++;
				continue;
			}

			if (i % length == 0) {
				//System.out.println("Previuos Row Ends Here:");
				++row;
				int newColumn;
				for (int x = 0; x < xmlParameters.getSkipColumns().size(); x++) {
					newColumn = xmlParameters.getSkipColumns().get(x) + 24;
					xmlParameters.getSkipColumns().set(x, newColumn);
				}
			}
			column++;
			int index = i / length;

			//System.out.println("Adding Record : "+itemCode2 + (column-3) + "." + (Math.abs(index) + 1) +" "+
			//		Math.abs(index) + ""  +" "+ xmlParameters.getResult().get(i)+"");

			xmlParameters.getGenericXmls().add(new GenericXml(itemCode2 + (column-3) + "." + (Math.abs(index) + 1),
					Math.abs(index) + "", xmlParameters.getResult().get(i)));
			itemCode2 = itemCode;

		}
	}



    private static void writeIntoSpecialXmlFormatWithPrefixMstdr(XmlParameters xmlParameters)
    {
        int length = xmlParameters.getDaoClass().getFields().length ;
        String itemCode = xmlParameters.getReportName() + xmlParameters.getPrefix() + ".C";
        int row = -1;
        int column = 0;
        String itemCode2 = "";

        int dividingFactor;
        if (length > 1) {
            dividingFactor = length - 1;
        } else {
            dividingFactor = length;
        }

        for (int i = 0; i < xmlParameters.getResult().size(); i++) {
            if (i % length == 0) {
                column = 0;
            }

            if (column < 9) {
                itemCode2 = itemCode + "";
            }

            if (xmlParameters.isSkipColumns() && xmlParameters.getSkipColumns().contains(i)) {
                //System.out.println("Skipping :" + i);
                column++;
                continue;
            }else if(xmlParameters.isSkipColumns() && xmlParameters.getSkipColumns().contains(i) && i % length == 0) {
                //System.out.println("Previuos Row Ends Here And Now:");
                ++row;
                int newColumn;
                for (int x = 0; x < xmlParameters.getSkipColumns().size(); x++) {
                    newColumn = xmlParameters.getSkipColumns().get(x) + 24;
                    xmlParameters.getSkipColumns().set(x, newColumn);
                }
                column++;
                continue;
            }

            if (i % length == 0) {
                //System.out.println("Previuos Row Ends Here:");
                ++row;
                int newColumn;
                for (int x = 0; x < xmlParameters.getSkipColumns().size(); x++) {
                    newColumn = xmlParameters.getSkipColumns().get(x) + 24;
                    xmlParameters.getSkipColumns().set(x, newColumn);
                }
            }
            column++;
            int index = i / length;

            //System.out.println("Adding Record : "+itemCode2 + (column-3) + "." + (Math.abs(index) + 1) +" "+
            //		Math.abs(index) + ""  +" "+ xmlParameters.getResult().get(i)+"");

            xmlParameters.getGenericXmls().add(new GenericXml(itemCode2 + (column-3) + "." + (Math.abs(index) + 1),
                0 + "", xmlParameters.getResult().get(i)));
            itemCode2 = itemCode;

        }
    }


}
