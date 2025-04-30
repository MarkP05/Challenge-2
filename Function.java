import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
import github.tools.responseObjects.CreateRepoResponse;
import github.tools.responseObjects.GetRepoInfoResponse;

public class Function {
    public static void createRepo(String repoPath, String repoName, String userName, String token) {
        GitHubApiClient gitHubApiClient = new GitHubApiClient(userName, token);
        
        //String repoName = "NewRepo";
        //String repoPath = "C:/Users/Rei/Documents/Homepage/colleg year 1/2-CSC109/week 12/Challenge-2";
        
        RequestParams requestParams = new RequestParams();
        requestParams.addParam("name", repoName); // name of repo
        
        CreateRepoResponse createRepoResponse = gitHubApiClient.createRepo(requestParams);
        
        //GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);

    }
}