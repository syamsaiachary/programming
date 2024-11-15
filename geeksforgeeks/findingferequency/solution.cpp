#include <vector>
#include<iostream>
using namespace std;



//answer
class Solution {
  public:
    void frequencyCount(vector<int>& arr, int N, int P) {
        vector<int> freq(N, 0);

        for (int i = 0; i < N; i++) {
            if (arr[i] >= 1 && arr[i] <= N) {
                freq[arr[i] - 1]++;
            }
        }

        for (int i = 0; i < N; i++) {
            arr[i] = freq[i];
        }
    }
};



//driver code
int main() {
    long long t;

    // testcases
    cin >> t;

    while (t--) {

        int N, P;
        // size of array
        cin >> N;

        vector<int> arr(N);

        // adding elements to the vector
        for (int i = 0; i < N; i++) {
            cin >> arr[i];
        }
        cin >> P;
        Solution ob;
        // calling frequncycount() function
        ob.frequencyCount(arr, N, P);

        // printing array elements
        for (int i = 0; i < N; i++)
            cout << arr[i] << " ";
        cout << endl;

        cout << "~" << "\n";
    }
    return 0;
}
