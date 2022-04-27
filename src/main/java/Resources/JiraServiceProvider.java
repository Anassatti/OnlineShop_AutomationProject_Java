package Resources;

import java.io.File;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {
	
	public JiraClient jira;
	public String project;
	public JiraServiceProvider(String jiraUrl, String username, String password, String project)
	{
		BasicCredentials cred=new BasicCredentials(username,password);
		jira=new JiraClient(jiraUrl,cred);
		this.project=project;
	}
	public Issue createJiraTicket(String issueType, String summary, String description) throws JiraException
	{
		FluentCreate fluent=jira.createIssue(project, issueType);
		fluent.field(Field.SUMMARY, summary);
		fluent.field(Field.DESCRIPTION, description);
		//fluent.field(Field.REPORTER, reporterName);
		
		Issue newIssue=fluent.execute();
		System.out.println("New Jira Bug created ID:"+newIssue);
		return newIssue;
		
		
	}
	public void Attachment( String jiraID, File string ) throws JiraException
	{
		Issue addAttachment=jira.getIssue(jiraID);
		addAttachment.addAttachment(string);
			
	}

}
