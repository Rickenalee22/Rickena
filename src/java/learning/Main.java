#!/usr/bin/perl
		use List::Util qw/sum max min/;
		sub Mean{
		return sum(@_)/@_;
}
		sub Variance{
		$mean = sum(@_)/@_;
	$result = 0;
			foreach $nums(@_){
		$result += ($nums - $mean)**2;
		}
		$result /= @_;
	$result **= 0.5;
			return $result;
			}
			sub Reg{
			foreach $content(@_){
		# ^                    for start
		# ([0-9.]+)\s          for IP address
		# ([\w.-]+)\s          for identity
		# ([\w.-]+)\s          for userid
		# (\[[^\[\]]+\])\s     for time
		# "((?:[^"]|\")+)"\s   for request message
		# (\d{3})\s            for status
		# (\d+|-)\s            for response length
		# "((?:[^"]|\")+)"\s   for referer
		# "((?:[^"]|\")+)"	   for user-agent
		# $                    for end
		print($content);
		if ($content = ~ m/^([0-9.]+)\s([\w.-]+)\s([\w.-]+)\s(\[[^\[\]]+\])\s"((?:[^"]|\")+)"\s(\d{3})\s(\d+|-)\s"((?:[^"]|\")+)"\s"((?:[^"]|\")+)"$/g){
		print("reg success\n");
		}else{
		print("reg fail");
		}

		}
		}
		#please change the file address
		open(DATA,"<","./access.log") or die "file cannot open.";
		@linelist = <DATA>;
		@successtime = (20,15,69,24);
		foreach $eachline(@linelist){
		Reg($eachline);
		last;
		}
		print("@successtime\n");
		my($max)  = max @successtime;
		my($min)  = min @successtime;
		print("$max\n");
		print("$min\n");
		my($mean) = Mean(@successtime);
		print("$mean\n");
		my($variance) = Variance(@successtime);
		print("$variance\n");
		close(DATA);