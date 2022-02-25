package org.toasthub.common;

import org.toasthub.utils.Request;
import org.toasthub.utils.Response;

public interface BaseSvc {
	public void process(Request request, Response response);
	public void save(Request request, Response response);
	public void delete(Request request, Response response);
	public void item(Request request, Response response);
	public void items(Request request, Response response);
}
