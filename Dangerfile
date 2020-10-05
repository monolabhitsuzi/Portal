# Ignore out of range message
github.dismiss_out_of_range_messages

# Ignore review if title includes [WIP]
failure("This PR seem WIP, you should not review and merge.") if github.pr_title.include? "[WIP]"

# Warning Too many line changes.
warn("Too many changes") if git.lines_of_code > 1000

# ktlint
checkstyle_format.base_path = Dir.pwd
Dir["**/reports/ktlint-results.xml"].each do |file|
  checkstyle_format.report file
end

# android lint
android_lint.skip_gradle_task = true
android_lint.filtering = true
Dir["*/build/reports/lint-results*.xml"].each do |file|
  android_lint.report_file = file
  android_lint.lint(inline_mode: true)
end
