package customWorkItem;

import java.util.HashMap;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

public class StructPermitWorkItem implements org.kie.api.runtime.process.WorkItemHandler {

	public void abortWorkItem(WorkItem arg0, WorkItemManager arg1) {
		// TODO Auto-generated method stub
		
	}

	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		
		String prevSRejection = workItem.getParameter("prevSRejection").toString();
		
		System.out.println("StructPermitWorkItem ::"+prevSRejection);
		
		HashMap<String, Object> results = new HashMap<String, Object>();
		
		if (prevSRejection.equalsIgnoreCase("No")) {
			results.put("structPermitStatus", "Approved");
		}
		if (prevSRejection.equalsIgnoreCase("Yes")) {
			results.put("structPermitStatus", "Rejected");
		}
		if (prevSRejection.equalsIgnoreCase("Unknown")){
			results.put("structPermitStatus", "Pending");
		}
		
		workItemManager.completeWorkItem(workItem.getId(), results);
	}

}
