# Combining Loops and Functions

**Lesson Duration: 30 minutes**

### Learning Objectives
- Understand how to combine loops and functions

## Combining Loops and Functions

So far we have just been using `p` to give us information back from our loops. However, in practice we will usually be using loops inside of a function, where instead of using `p` we will want to send information back as the return value of the function.

## Simple Use of Loop in a Function

We can easily make our egg counting loop go inside a function. We should pass in the array, so that if we wanted to count eggs of a different array of chickens from another farm, we can use the same function.

We also want to return the string at the end, instead of using p, so we can test our code.

So let's create a new file for this:

```bash
#terminal

touch loops_in_functions.rb
```

```ruby
#loops_in_functions.rb
chicken_hashes = [
  { name: "Margaret", age: 2, eggs: 0 },
  { name: "Hetty", age: 1, eggs: 2 },
  { name: "Henrietta", age: 3, eggs: 1 },
  { name: "Audrey", age: 2, eggs: 0 },
  { name: "Mabel", age: 0.5, eggs: 1 },
]

def count_collected_eggs(chicken_array)
  total_eggs_collected = 0

  for chicken in chicken_array
    total_eggs_collected += chicken[:eggs]
    chicken[:eggs] = 0
  end

  return total_eggs_collected.to_s() + " eggs collected"
end

p count_collected_eggs(chicken_hashes)
```

## Returns Within a Loop

Maybe we want to find out if we have a chicken with a certain name on the farm, and make sure it's not been stolen by a fox.

Outside of a function it might look like this:

```ruby
#loops_in_functions.rb

for chicken in chicken_hashes
  if chicken[:name] == "Audrey"
    p "I found Audrey!"
  end
end
```

But now if we want to make this flexible/dynamic, we can make the name finder a function. What parameters does it need? The array, and a name to search for.

```ruby
#loops_in_functions.rb

def find_chicken_by_name(chicken_array, chicken_name)

end
```

Now we need to put our loop in there, but instead of referring directly to the `chicken_hashes` array, we're passing that in. So, we just loop through the `chicken_array` parameter. And instead of looking for "Audrey" we just put in `chicken_name`.

```ruby
#loops_in_functions.rb

def find_chicken_by_name( chicken_array, chicken_name )
  for chicken in chicken_array
    if chicken[:name] == chicken_name
      p "I found #{chicken_name}!"
    end
  end
end

find_chicken_by_name(chicken_hashes, "Audrey")
find_chicken_by_name(chicken_hashes, "Hetty")
```

As mentioned, we don't want to just use `p` in functions all the time though, as this is very hard to test. Instead we should return something from the function.

```ruby
#loops_in_functions.rb

if chicken[:name] == chicken_name
  return "I found #{chicken_name}!"
end

result1 = find_chicken_by_name(chicken_hashes, "Audrey")
result2 = find_chicken_by_name(chicken_hashes, "Hetty")

p result1
p result2
```

We also tend not to return strings too much. Instead we can return the whole chicken hash so we have more options of what to do with it.

```ruby
#loops_in_functions.rb

if chicken[:name] == chicken_name
  return chicken
end
```

Finally, what if we search for a chicken who's not there? Currently, what do we get?

```ruby
#loops_in_functions.rb

result3 = find_chicken_by_name(chicken_hashes, "Elsie")

p result3
```

The whole array of hashes! As we've not executed a return, Ruby returns the last item it's touched (the last thing it evaluated) - in this case, the array that was looped over.

If we want to return something more meaningful, we can do so at the end. We might return an error message, or `nil`.

```ruby
#loops_in_functions.rb

def find_chicken_by_name( chicken_array, chicken_name )
  for chicken in chicken_array
    if chicken[:name] == chicken_name
      return chicken
    end
  end

  return "Not found"
end
```