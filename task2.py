#!/usr/bin/env python3

if __name__ == '__main__':

    print("Park Run Timer\n~~~~~~~~~~~~~~\n\nLet's go!")

    def seconds_conversion(seconds):
        minutes = seconds // 60
        remaining_seconds = seconds % 60

        return f"{minutes} minutes, {remaining_seconds} seconds"

    runner_numbers = []
    runner_times = []

    while True:
        number_and_time = input("> ")
        runner_info = number_and_time.split("::")
        try:
            if number_and_time == "END" and len(runner_numbers) == 0 and len(runner_times) == 0:
                print("No data found. Nothing to do. What a pity.")
                exit()
            if number_and_time == "END":
                break
            else:
                runner_numbers.append(int(runner_info[0]))
                runner_times.append(int(runner_info[1]))
        except ValueError:
            print("Error")

    total_runners = len(runner_numbers)
    average_time = int((sum(runner_times)) / (len(runner_times)))
    fastest_time = max(runner_times)
    slowest_time = min(runner_times)
    best_time = runner_numbers[runner_times.index(min(runner_times))]

    print("Total Runners:", total_runners)
    print("Average Time:", (seconds_conversion(average_time)))
    print("Fastest Time:", seconds_conversion(fastest_time))
    print("Slowest Time:", seconds_conversion(slowest_time))
    print()
    print("Best time here: Runner #", best_time)
