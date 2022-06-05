package org.toasthub.common;

import java.math.BigDecimal;

import org.toasthub.utils.Request;
import org.toasthub.utils.Response;

public class RequestValidation {

    public static void validateShortSMAType(Request request, Response response) {
        String string = "";
        String substring = "";
        int i = 0;

        string = (String) request.getParam("shortSMAType");

        if (!string.endsWith("-" + ((String) request.getParam("EVALUATION_PERIOD")).toLowerCase())) {
            response.setStatus(Response.ERROR);
            return;
        }

        substring = string.substring(0,
                string.length() - ((String) request.getParam("EVALUATION_PERIOD")).length() - 1);
        try {
            i = Integer.parseInt(substring);
        } catch (NumberFormatException e) {
            response.setStatus(Response.ERROR);
            return;
        }

        if (i <= 0 || i > 999) {
            return;
        }

        request.addParam("SHORT_SMA_TYPE", request.getParam("shortSMAType"));
    }

    public static void validateLongSMAType(Request request, Response response) {
        String string = "";
        String substring = "";
        int i = 0;

        string = (String) request.getParam("longSMAType");

        if (!string.endsWith("-" + ((String) request.getParam("EVALUATION_PERIOD")).toLowerCase())) {
            response.setStatus(Response.ERROR);
            return;
        }
        substring = string.substring(0,
                string.length() - ((String) request.getParam("EVALUATION_PERIOD")).length() - 1);
        try {
            i = Integer.parseInt(substring);
        } catch (NumberFormatException e) {
            response.setStatus(Response.ERROR);
            return;
        }

        if (i <= 0 || i > 999) {
            response.setStatus(Response.ERROR);
            return;
        }

        request.addParam("LONG_SMA_TYPE", request.getParam("longSMAType"));
    }

    public static void validateLBBType(Request request, Response response) {
        String string = "";
        String substring = "";
        int i = 0;

        string = (String) request.getParam("lbbType");

        if (!string.endsWith("-" + ((String) request.getParam("EVALUATION_PERIOD")).toLowerCase())) {
            response.setStatus(Response.ERROR);
            return;
        }
        substring = string.substring(0,
                string.length() - ((String) request.getParam("EVALUATION_PERIOD")).length() - 1);
        try {
            i = Integer.parseInt(substring);
        } catch (NumberFormatException e) {
            response.setStatus(Response.ERROR);
            return;
        }

        if (i <= 0 || i > 999) {
            response.setStatus(Response.ERROR);
            return;
        }

        request.addParam("LBB_TYPE", (String) request.getParam("lbbType"));
    }

    public static void validateUBBType(Request request, Response response) {
        String string = "";
        String substring = "";
        int i = 0;

        string = (String) request.getParam("ubbType");

        if (!string.endsWith("-" + ((String) request.getParam("EVALUATION_PERIOD")).toLowerCase())) {
            response.setStatus(Response.ERROR);
            return;
        }
        substring = string.substring(0,
                string.length() - ((String) request.getParam("EVALUATION_PERIOD")).length() - 1);
        try {
            i = Integer.parseInt(substring);
        } catch (NumberFormatException e) {
            response.setStatus(Response.ERROR);
            return;
        }

        if (i <= 0 || i > 999) {
            response.setStatus(Response.ERROR);
            return;
        }

        request.addParam("UBB_TYPE", (String) request.getParam("ubbType"));
    }

    public static void validateStandardDeviations(Request request, Response response) {
        BigDecimal num = BigDecimal.ZERO;

        if (request.getParam("standardDeviations") instanceof String) {
            num = new BigDecimal((String) request.getParam("standardDeviations"));
        }

        if (request.getParam("standardDeviations") instanceof Double) {
            num = BigDecimal.valueOf((Double) request.getParam("standardDeviations"));
        }

        if (num.compareTo(BigDecimal.ZERO) <= 0 || num.compareTo(BigDecimal.TEN) > 0) {
            response.setStatus(Response.ERROR);
            return;
        }
        num = num.setScale(1, BigDecimal.ROUND_HALF_UP);

        request.addParam("STANDARD_DEVIATIONS", num);
    }
}
