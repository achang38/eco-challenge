git filter-branch -f --env-filter '

CORRECT_NAME="shi428"
CORRECT_EMAIL="shi428@purdue.edu"

if [ "$GIT_COMMITTER_NAME" != "$CORRECT_NAME" ]
then
  export GIT_COMMITTER_NAME="$CORRECT_NAME"
  export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
fi
if [ "$GIT_COMMITTER_NAME" != "CORRECT_NAME" ]
then
  export GIT_AUTHOR_NAME="$CORRECT_NAME"
  export GIT_AUTHOR_EMAIL="$CORRECT_EMAIL"
fi
' --tag-name-filter cat -- --branches --tags
