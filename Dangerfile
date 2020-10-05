# Ignore out of range message
github.dismiss_out_of_range_messages

# Ignore review if title includes [WIP]
failure("This PR seem WIP, you should not review and merge.") if github.pr_title.include? "[WIP]"

# Warning Too many line changes.
warn("Too many changes") if git.lines_of_code > 1000
