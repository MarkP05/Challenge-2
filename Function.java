import git.tools.client.GitSubprocessClient;
import github.tools.client.GitHubApiClient;
import github.tools.client.RequestParams;
import github.tools.responseObjects.CreateRepoResponse;
import github.tools.responseObjects.GetRepoInfoResponse;

public class Function {
    public static boolean repoExists(String userName, String repoName, String token) {
        GitHubApiClient gitHubApiClient = new GitHubApiClient(userName, token);
        try {
            GetRepoInfoResponse response = gitHubApiClient.getRepoInfo(repoName, token);
            return response != null; // If the response is not null, the repo exists
        } catch (Exception e) {
            return false; // If an exception occurs, assume the repo does not exist
        }
    }

    public static void createRepo(String repoPath, String repoName, String userName, String token) {
        GitHubApiClient gitHubApiClient = new GitHubApiClient(userName, token);

        if (repoExists(userName, repoName, token)) {
            System.err.println("Repository with name '" + repoName + "' already exists on GitHub. Skipping creation.");
            return;
        }

        try {
            RequestParams requestParams = new RequestParams();
            requestParams.addParam("name", repoName); // Name of the repository

            CreateRepoResponse createRepoResponse = gitHubApiClient.createRepo(requestParams);
            System.out.println("GitHub repository created successfully.");
        } catch (Exception e) {
            System.err.println("Failed to create GitHub repository: " + e.getMessage());
            e.printStackTrace();
        }
    }
}